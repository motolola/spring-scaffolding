package com.motolola.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.motolola.model.Todo;
import com.motolola.todo.service.TodoService;

@Controller 
public class TodoController {
	
	@Autowired 
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model)
	{
		model.addAttribute("todos",service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model)
	{
		model.addAttribute("todo", 
				new Todo(0, 
				"in28minutes", 
				"", 
				new Date(), 
				false));
				
		return "add-todo";
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoAction(@Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors()) {
			return "add-todo";
		}
		service.addTodo("in28Minutes", todo.getDesc(), new Date(), false);
		return "redirect:list-todos";
	}
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoAction(@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id)
	{
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		
		return "add-todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodoAction(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors()) {
			return "add-todo";
		}
		//todo.setTargetDate(new Date());

		service.updateTodo(todo);
		//model.addAttribute("todo", todo);
		
		return "redirect:list-todos";
	}
	

}

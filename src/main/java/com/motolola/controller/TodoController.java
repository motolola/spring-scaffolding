package com.motolola.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.motolola.todo.service.TodoService;

@Controller 
public class TodoController {
	
	@Autowired 
	TodoService service;
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model)
	{
		model.addAttribute("todos",service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo()
	{
		return "add-todo";
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoAction(@RequestParam String desc)
	{
		service.addTodo("in28Minutes", desc, new Date(), false);
		return "redirect:list-todos";
	}
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoAction(@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	

}

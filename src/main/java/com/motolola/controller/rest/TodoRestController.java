package com.motolola.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motolola.model.Todo;
import com.motolola.todo.service.TodoService;

@RestController
public class TodoRestController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(path = "/api/todo", method = RequestMethod.GET)
	public List<Todo> retrieveAllTodos()
	{
		List<Todo> users = service.retrieveTodos("in28Minutes");
		return users;
	}
	@RequestMapping(path = "/api/todo/{id}", method = RequestMethod.GET)
	public Todo retrieveATodo(@PathVariable int id)
	{
		return service.retrieveTodo(id);
		
	}

}

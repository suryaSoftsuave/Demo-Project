package com.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("listOfTodos", todoService.getAllTodos());
		mv.setViewName("listTodo");
		return mv;
	}
	
	@PostMapping("/deleteTodo")
	public ModelAndView deleteTodo(@RequestParam int todoid)
	{
		System.out.println("Inside the delete controller");
		ModelAndView mv = new ModelAndView();
		todoService.deleteTodo(todoid);
		mv.addObject("listOfTodos", todoService.getAllTodos());
		mv.setViewName("listTodo");
		return mv;
	
	}
	
	@RequestMapping("/addTodo")
	public ModelAndView addTodo(Todo todo)
	{
		ModelAndView mv = new ModelAndView();
		if(todo.getTask() == null)
		{
			mv.setViewName("createTodo");
		}
		else {
			todoService.saveTodo(todo);
			mv.addObject("listOfTodos", todoService.getAllTodos());
			mv.setViewName("listTodo");
		}
		return mv;
	}
}

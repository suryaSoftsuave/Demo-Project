package com.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoRepository todoRepository;
	
	public List<Todo> getAllTodos()
	{
		return todoRepository.findAll();
	}
	
	public void saveTodo(Todo todo)
	{
		todoRepository.save(todo);
	}
	
	public void deleteTodo(int todoid)
	{
		todoRepository.delete(todoRepository.findById(todoid).get());
	}
}

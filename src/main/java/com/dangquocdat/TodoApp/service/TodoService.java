package com.dangquocdat.TodoApp.service;

import com.dangquocdat.TodoApp.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTodos();
    TodoDto getTodo(Long id);
    TodoDto addTodo(TodoDto todoDto);
    TodoDto updateTodo(Long id, TodoDto todoDto);
    String deleteTodo(Long id);
    TodoDto completeTodo(Long id);
    TodoDto inCompleteTodo(Long id);
}

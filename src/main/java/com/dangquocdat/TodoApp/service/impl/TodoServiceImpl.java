package com.dangquocdat.TodoApp.service.impl;

import com.dangquocdat.TodoApp.dto.TodoDto;
import com.dangquocdat.TodoApp.entity.Todo;
import com.dangquocdat.TodoApp.exception.ResourceNotFoundException;
import com.dangquocdat.TodoApp.repository.TodoRepository;
import com.dangquocdat.TodoApp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.BooleanNode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TodoDto> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream()
                .map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Todo is not exists with given id: "+id));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // convert dto to entity:
        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {

        Todo todo = todoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Toto is not exists with given id: "+id));

        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public String deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Toto is not exists with given id: "+id));

        todoRepository.deleteById(id);

        return "Delete todo successfully!";
    }

    @Override
    public TodoDto completeTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Toto is not exists with given id: "+id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Toto is not exists with given id: "+id));

        todo.setCompleted(Boolean.FALSE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }


}

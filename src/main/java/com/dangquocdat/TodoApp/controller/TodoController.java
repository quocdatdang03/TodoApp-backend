package com.dangquocdat.TodoApp.controller;

import com.dangquocdat.TodoApp.dto.TodoDto;
import com.dangquocdat.TodoApp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {

        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long id) {

        return ResponseEntity.ok(todoService.getTodo(id));
    }

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoService.addTodo(todoDto));

    }

    // PUT : using to update whole resource
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(
            @PathVariable("id") Long id,
            @RequestBody TodoDto todoDto
    ) {

        return ResponseEntity.ok(todoService.updateTodo(id, todoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) {

        return ResponseEntity.ok(todoService.deleteTodo(id));
    }

    // PATCH : using to update resource partially ( chỉ update 1 phần của resource)
    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long id) {

        return ResponseEntity.ok(todoService.completeTodo(id));
    }

    @PatchMapping("/{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long id) {

        return ResponseEntity.ok(todoService.inCompleteTodo(id));
    }



}

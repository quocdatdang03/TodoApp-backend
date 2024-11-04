package com.dangquocdat.TodoApp.repository;

import com.dangquocdat.TodoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

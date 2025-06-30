package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
  private final TaskRepository repository;

  public TaskController(TaskRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Task> getAll() {
    return repository.findAll();
  }

  @PostMapping
  public Task create(@RequestBody Task task) {
    return repository.save(task);
  }

  @PutMapping("/{id}")
  public Task update(@PathVariable Long id, @RequestBody Task task) {
    task.setId(id);
    return repository.save(task);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}

package com.projecthub.healthdashboard.controller;

import com.projecthub.healthdashboard.model.Task;
import com.projecthub.healthdashboard.service.TaskService;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    // Konstruktor-Injection
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        // Gibt alle Tasks aus der Datenbank zurück.
        return taskService.findAll();
    }

    @GetMapping("/projekt/{projektId}")
    public List<Task> getTasksForProjekt(@PathVariable Long projektId) {
        // Gibt alle Tasks zurück, die zu einem bestimmten Projekt gehören.
        return taskService.findByProjektId(projektId);
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}


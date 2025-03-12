package com.example.testapplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testapplication.Dto.CreateTaskDTO;
import com.example.testapplication.entities.TaskEntity;
import com.example.testapplication.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }   



    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {

        var tasks = taskService.getTasks();

        return ResponseEntity.ok(tasks);
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id) {

        var task = taskService.getTasksById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO Body) {

        var task = taskService.addTask(Body.getTittle(), Body.getDescription(), Body.getDeadline());

        return ResponseEntity.ok(task);
    }
}

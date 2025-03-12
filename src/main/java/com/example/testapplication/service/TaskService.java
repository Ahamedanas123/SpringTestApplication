package com.example.testapplication.service;

import com.example.testapplication.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String tittle, String description, String deadline) {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTittle(tittle);
        task.setDescription(description);
        // task.setDeadline(new Date(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }

    public ArrayList<TaskEntity> getTasks(){
        return tasks;
    }

    public TaskEntity getTasksById(int id){
        for(TaskEntity task:tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }

}

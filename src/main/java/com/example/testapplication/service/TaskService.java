package com.example.testapplication.service;

import com.example.testapplication.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEntity addTask(String tittle, String description, String deadline) throws ParseException{ 
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTittle(tittle);
        task.setDescription(description);
        task.setDeadline(deadlineFormatter.parse(deadline));
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

     public TaskEntity updateTask(int id, String description, String deadline, Boolean completed) throws ParseException {
        TaskEntity task = getTasksById(id);
        if(task == null){
            return null;
        }
        if(description != null){
            task.setDescription(description);
        }
        if(deadline != null){
            task.setDeadline(deadlineFormatter.parse(deadline));
        }
        if(completed != null){
            task.setCompleted(completed);
        }
        return task;
    }
}

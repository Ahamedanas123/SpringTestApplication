package com.example.testapplication.entities;

import java.util.Date;

import lombok.Data;

@Data

public class TaskEntity {
    private int id;
    private String tittle;
    private String description;
    private boolean completed;
    private Date deadline;

}

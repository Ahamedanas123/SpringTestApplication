package com.example.testapplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UpdateTaskDTO {
    private String description;
    private String deadline;
    private Boolean completed;

}

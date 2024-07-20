package com.example.Timesheet.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class TimesheetDTO {
    private long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean lunch;
    private LocalTime lunchOther;
    private String description;
    private String userEmail;
    private String projectName;
}

package com.example.Timesheet.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CalendarDTO {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean lunch;
    private String description;
}

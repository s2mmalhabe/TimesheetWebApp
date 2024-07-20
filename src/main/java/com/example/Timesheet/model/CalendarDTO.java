package com.example.Timesheet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class CalendarDTO {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean lunch;
    private String description;
}

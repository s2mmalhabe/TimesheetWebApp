package com.example.Timesheet.controller;

import com.example.Timesheet.model.CalendarDTO;
import com.example.Timesheet.model.CustomResponse;
import com.example.Timesheet.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @PostMapping
    public CustomResponse saveCalendar(@RequestBody CalendarDTO calendarDTO) {
        return new CustomResponse(this.calendarService.save(calendarDTO));
    }

    @GetMapping
    public CustomResponse getByDate(@RequestBody LocalDate date) {
        return new CustomResponse(calendarService.getByDate(date));
    }
}

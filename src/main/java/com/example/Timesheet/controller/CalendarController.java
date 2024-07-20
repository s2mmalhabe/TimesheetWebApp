package com.example.Timesheet.controller;

import com.example.Timesheet.model.CalendarDTO;
import com.example.Timesheet.model.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
public class CalendarController {
    @PostMapping
    public CustomResponse saveCalendar(@RequestBody CalendarDTO calendarDTO) {
        return new CustomResponse(calendarDTO);
    }
}

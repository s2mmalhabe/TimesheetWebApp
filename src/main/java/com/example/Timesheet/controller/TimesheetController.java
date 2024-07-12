package com.example.Timesheet.controller;

import com.example.Timesheet.entity.Timesheet;
import com.example.Timesheet.service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
@RequiredArgsConstructor
public class TimesheetController {

    private final TimesheetService timesheetService;

    @PostMapping
    public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
        return timesheetService.createTimesheet(timesheet);
    }

    @GetMapping("/user/{userId}")
    public List<Timesheet> getTimesheetsByUserId(@PathVariable Long userId) {
        return timesheetService.getTimesheetsByUserId(userId);
    }

    @PutMapping("/{id}")
    public Timesheet updateTimesheet(@PathVariable Long id, @RequestBody Timesheet timesheet) {
        timesheet.setId(id);
        return timesheetService.updateTimesheet(timesheet);
    }

    @DeleteMapping("/{id}")
    public void deleteTimesheet(@PathVariable Long id) {
        timesheetService.deleteTimesheet(id);
    }
}

package com.example.Timesheet.service;

import com.example.Timesheet.entity.Timesheet;
import com.example.Timesheet.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetService {

    private final TimesheetRepository timesheetRepository;

    public Timesheet createTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public List<Timesheet> getTimesheetsByUserId(Long userId) {
        return timesheetRepository.findByUserId(userId);
    }

    public Timesheet updateTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public void deleteTimesheet(Long id) {
        timesheetRepository.deleteById(id);
    }
}

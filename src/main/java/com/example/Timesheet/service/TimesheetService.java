package com.example.Timesheet.service;

import com.example.Timesheet.entity.Timesheet;
import com.example.Timesheet.model.TimesheetDTO;
import com.example.Timesheet.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetService {
    private final ModelMapper modelMapper = new ModelMapper();

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

    private TimesheetDTO timesheetToDto(Timesheet timesheet) {
        TimesheetDTO dto = modelMapper.map(timesheet, TimesheetDTO.class);
        dto.setUserEmail(timesheet.getUser().getEmail());
        dto.setProjectName(timesheet.getProject().getName());
        return dto;
    }

    public void deleteTimesheet(Long id) {
        timesheetRepository.deleteById(id);
    }
}

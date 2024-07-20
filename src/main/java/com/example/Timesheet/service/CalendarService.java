package com.example.Timesheet.service;

import com.example.Timesheet.entity.Timesheet;
import com.example.Timesheet.model.CalendarDTO;
import com.example.Timesheet.model.CustomResponse;
import com.example.Timesheet.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalendarService {
    private final TimesheetRepository timesheetRepository;

    private CalendarDTO timesheetToCalendar(Timesheet timesheet) {
        return new CalendarDTO(timesheet.getDate(),
                timesheet.getStartTime(),
                timesheet.getEndTime(),
                timesheet.isLunch(),
                timesheet.getDescription());
    }

    public CustomResponse getByDate(LocalDate date) {
        Optional<Timesheet> opt = timesheetRepository.findByUserIdAndDate(1L, date);
        if (opt.isPresent()) {
            Timesheet timesheet = opt.get();
            return new CustomResponse(this.timesheetToCalendar(timesheet));
        }
        return new CustomResponse(null);
    }

    public CustomResponse getAllByUser(long userId) {
        List<CalendarDTO> calendars = new ArrayList<>();
        for (Timesheet timesheet : this.timesheetRepository.findByUserId(userId))
            calendars.add(this.timesheetToCalendar(timesheet));
        return new CustomResponse(calendars);
    }

    public CustomResponse save(CalendarDTO calendar) {
        if (calendar.getDate().isAfter(LocalDate.now()))
            return new CustomResponse(null, "Can't save future dates!");
        Optional<Timesheet> opt = timesheetRepository.findByUserIdAndDate(1L, calendar.getDate());
        Timesheet timesheet = opt.orElseGet(Timesheet::new);
        timesheet.setDate(calendar.getDate());
        timesheet.setStartTime(calendar.getStartTime());
        timesheet.setEndTime(calendar.getEndTime());
        timesheet.setLunch(calendar.isLunch());
        timesheet.setDescription(calendar.getDescription());
        this.timesheetRepository.save(timesheet);
        return new CustomResponse(true);
    }
}

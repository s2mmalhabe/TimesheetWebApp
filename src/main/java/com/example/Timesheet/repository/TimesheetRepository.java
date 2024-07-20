package com.example.Timesheet.repository;

import com.example.Timesheet.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    List<Timesheet> findByUserId(Long userId);
    Optional<Timesheet> findByUserIdAndDate(Long userId, LocalDate date);
}

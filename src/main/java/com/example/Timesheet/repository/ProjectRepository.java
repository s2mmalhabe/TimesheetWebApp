package com.example.Timesheet.repository;

import com.example.Timesheet.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

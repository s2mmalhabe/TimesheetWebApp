package com.example.Timesheet.model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.util.StringMap;

import java.util.Set;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "project")
    private Set<Timesheet> timesheets;

    public Long getId() {
        return id;
    }

}

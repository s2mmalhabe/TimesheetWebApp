package com.example.Timesheet.model;

import com.example.Timesheet.entity.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private Role role;
}

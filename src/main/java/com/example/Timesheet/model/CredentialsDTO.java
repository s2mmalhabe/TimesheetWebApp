package com.example.Timesheet.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CredentialsDTO {
    private String email;
    private String password;
}

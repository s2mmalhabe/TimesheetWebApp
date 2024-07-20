package com.example.Timesheet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse {
    boolean success;
    Object object;
    String message;

    public CustomResponse(Object object) {
        this.success = object != null;
        this.object = object;
    }

    public CustomResponse(Object object, String message) {
        this.success = object != null;
        this.object = object;
        this.message = message;
    }
}

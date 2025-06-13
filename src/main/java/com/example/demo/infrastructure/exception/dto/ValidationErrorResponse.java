package com.example.demo.infrastructure.exception.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ValidationErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private List<String> errors;

    public ValidationErrorResponse(LocalDateTime timestamp, int status, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.errors = errors;
    }
}


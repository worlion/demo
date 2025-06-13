package com.example.demo.infrastructure.exception.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;

    public SimpleErrorResponse(LocalDateTime timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
}


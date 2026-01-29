package com.example.inventory_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime time;

    public ErrorResponse(int i, String message) {
    }
}

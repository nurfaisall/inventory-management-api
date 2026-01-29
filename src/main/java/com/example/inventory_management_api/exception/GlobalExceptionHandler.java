package com.example.inventory_management_api.exception;

import com.example.inventory_management_api.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex){
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(400,ex.getMessage()));
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(BadRequestException ex){
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(404,ex.getMessage()));
    }

}

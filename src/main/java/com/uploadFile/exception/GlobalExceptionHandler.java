package com.uploadFile.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileEmptyException.class)
    public ResponseEntity<Object> fileEmptyExceptionMethod(FileEmptyException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatus(),LocalDateTime.now(), ex.getMessage() );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(ExtensionNotValidException.class)
    public ResponseEntity<Object> extensionNotValidExceptionMethod(ExtensionNotValidException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatus(),LocalDateTime.now(), ex.getMessage() );
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
    
}

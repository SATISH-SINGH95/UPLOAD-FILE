package com.uploadFile.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message;

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime time;


    public ErrorResponse(){
        time = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status, LocalDateTime time){
        this.status = status;
        this.time = time;
    }

    public ErrorResponse(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(HttpStatus status, LocalDateTime time, String message){
        this.status = status;
        this.message = message;
    }   
    
}

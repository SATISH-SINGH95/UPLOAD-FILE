package com.uploadFile.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtensionNotValidException extends RuntimeException{

     private String message;

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime time;


    public ExtensionNotValidException(){
        time = LocalDateTime.now();
    }

    public ExtensionNotValidException(HttpStatus status){
        this();
        this.status = status;
    }

    public ExtensionNotValidException(HttpStatus status, String message){
        this();
        this.status = status;
        this.message = message;
    }  
    
}

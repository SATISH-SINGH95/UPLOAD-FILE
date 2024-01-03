package com.uploadFile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploadFile.exception.FileEmptyException;
import com.uploadFile.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
        
        fileService.uploadFiles(file);

        if(file.isEmpty()){
            throw new FileEmptyException(HttpStatus.BAD_REQUEST, "File can not be empty");
        }

        return new ResponseEntity<>("FILE_SUCCESSFULLY_UPLOADED", HttpStatus.OK);

    }
    
}

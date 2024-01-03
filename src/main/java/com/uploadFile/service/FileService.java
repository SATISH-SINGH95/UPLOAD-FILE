package com.uploadFile.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    String uploadFiles(MultipartFile file) throws IOException;
}

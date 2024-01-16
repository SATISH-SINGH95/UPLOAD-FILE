package com.uploadFile.service.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uploadFile.exception.ExtensionNotValidException;
import com.uploadFile.service.FileService;

@Service
public class FileServiceImpl implements FileService{
    
    @Value("${file.path}")
    private String path;


    @Override
    public String uploadFiles(MultipartFile file) throws IOException {

        List<String> extensionList = Arrays.asList(".doc", ".docx", ".png", ".jpeg", ".jpg", ".pdf", ".txt");

        // get original file name from multipartFile
        String fileName = file.getOriginalFilename();

        String extensionOfFile = fileName.substring(fileName.lastIndexOf('.'));  // will give output as -> .pdf, .docx, .jpeg

        //String extensionOfFile = fileName.substring(fileName.lastIndexOf('.')+1);  // will give output as -> pdf, docx
        //To avoid duplicate name we can use this logic
        String randomId = UUID.randomUUID().toString();
        String fileName1 = randomId.concat(fileName.substring(fileName.lastIndexOf('.')));

        //full path of file
        String fullPath = path + File.separator + fileName1;

        if(!extensionList.contains(extensionOfFile.toLowerCase())){
            throw new ExtensionNotValidException(HttpStatus.BAD_REQUEST, "Extension is not supported");
        }

        // upload file to localSystem / Copy file to localSystem
        //Files.copy(file.getInputStream(), Paths.get(fullPath));  -- we can use this also
        file.transferTo(new File(fullPath));

    
        return fileName + " Uploaded successfully";
        
       
    }
    
}

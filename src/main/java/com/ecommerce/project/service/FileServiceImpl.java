package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile image) throws IOException {
        //file names of current/original file
        String originalFileName = image.getOriginalFilename();

        //rename the file/generate
        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = path + File.separator + fileName;

        //check if path exists and create
        File folder = new File(path);
        if (!folder.exists())
            folder.mkdirs();

        //upload to server
        Files.copy(image.getInputStream(), Paths.get(filePath));
        return fileName;
    }
}

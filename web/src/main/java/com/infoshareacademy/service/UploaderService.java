package com.infoshareacademy.service;


import com.infoshareacademy.exception.ApiFileNotFound;

import javax.ejb.Stateless;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Stateless
@MultipartConfig
public class UploaderService {

    public String uploadApiFile(Part filePart) throws ApiFileNotFound, IOException {

        String filename = Paths.get(filePart.getSubmittedFileName())
                .getFileName().toString();

        if (filename == null || filename.isEmpty()) {
            throw new ApiFileNotFound("No API file has been uploaded");
        }
        File file = new File(filename);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();

        Files.copy(fileContent, file.toPath());

        fileContent.close();

        String json = new String(Files.readAllBytes(Paths.get(file.getName())));

        return json;
    }
}

package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.exception.ApiFileNotFound;

import javax.ejb.Stateless;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Stateless
public class ApiLoaderToFile {

    public void getFromURL (String url) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("json.txt"), objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(url, new TypeReference<>() {
                }));
    }

    public File uploadApiFile(Part filePart) throws ApiFileNotFound, IOException {

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

        return file;
    }
}

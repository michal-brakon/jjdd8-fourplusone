package com.infoshareacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Stateless
@MultipartConfig
public class UploaderService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String uploadApiFile(Part filePart) throws IOException {

        String filename = Paths.get(filePart.getSubmittedFileName())
                .getFileName().toString();

        if (filename == null || filename.isEmpty()) {
            throw new FileNotFoundException("No file has been upload");
        }
        File file = new File(filename);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();

        Files.copy(fileContent, file.toPath());

        fileContent.close();

        return new String(Files.readAllBytes(Paths.get(file.getName())));
    }

    private String createImagePath() {
        String url;
        url = System.getenv("HOME");
        Path path = Paths.get(url + "/media/covers/");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                logger.info("New path directory for images has been created");
            } catch (IOException e) {
                e.getMessage();
                logger.warn("Failed to create path directory for images");
            }
        }
        return path.toString() + "/";

    }


    public String saveFile(Part tmpPart, String filename) throws Exception {


        File dstFile = new File(createImagePath() + filename);
        Files.deleteIfExists(dstFile.toPath());

        InputStream tmpPartInputStream = tmpPart.getInputStream();

        Files.copy(tmpPartInputStream, dstFile.toPath());

        tmpPartInputStream.close();

        logger.info("file save to {}", dstFile.getAbsolutePath());
        return dstFile.getAbsolutePath();
    }
}

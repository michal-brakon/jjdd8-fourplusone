package com.infoshareacademy.servlet;

import com.infoshareacademy.exception.ApiFileNotFound;
import com.infoshareacademy.service.ApiLoaderToFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet ("/uploader")
@MultipartConfig
public class LoaderFromFileServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    ApiLoaderToFile apiLoaderToFile;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part api = req.getPart("api");
        String apiURL = "";
        try {
            apiURL = apiLoaderToFile.uploadApiFile(api).getName();
        } catch
        (ApiFileNotFound apiFileNotFound) {
            logger.warn(apiFileNotFound.getMessage());
        }

    }
}

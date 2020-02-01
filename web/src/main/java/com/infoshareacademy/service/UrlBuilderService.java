package com.infoshareacademy.service;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UrlBuilderService {

        private static final String BASE_APP_URL = "http://fourplusone.jjdd8.is-academy.pl/";
//    private static final String BASE_APP_URL = "http://localhost:8080/";
    private static final String BASE_API_URL = "https://wolnelektury.pl/media/";

    public String buildBaseUrlForFile(String filename) {
        return BASE_APP_URL + filename;
    }

    public String buildImagesUrlForFile(String filename) {
        return buildBaseUrlForFile("images/" + filename);
    }

    public String buildApiImagesUrlForFile(String filename) {
        return BASE_API_URL + filename;
    }
}

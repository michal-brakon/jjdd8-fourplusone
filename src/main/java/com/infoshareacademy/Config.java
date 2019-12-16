package com.infoshareacademy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String PATHNAME = "config.properties";
    private String property;

    public void readPropValue(String config) {
        try (InputStream input = new FileInputStream(PATHNAME)) {
            Properties sort = new Properties();
            sort.load(input);
            property = sort.getProperty(config);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty() {
        return property;
    }
}

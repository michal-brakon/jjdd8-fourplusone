package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String PATHNAME = "config.properties";
    private String property;

    public void readPropValue(String config) {
        try (InputStream input = new FileInputStream(PATHNAME)) {
            Properties sort = new Properties();
            sort.load(input);
            property = sort.getProperty(config);
        } catch (IOException ex) {
          stdout.info("\n Pliku z konfiguracją nie znaleziono\n ");
        }
    }

    public String getProperty() {
        return property;
    }
}

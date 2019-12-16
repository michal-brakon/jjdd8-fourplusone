package com.infoshareacademy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppPropertiesReader {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    private Properties properties = new Properties();

    private File file = new File("config.properties");

    public String getProp(String config) {
        try {
            FileInputStream fileInput = new FileInputStream(file);
            properties.load(fileInput);
            fileInput.close();
        } catch (FileNotFoundException e) {
            stdout.info("\nBrak pliku!");
        } catch (IOException ex) {
            stdout.info("\nBlad odczytu pliku!");
        }
        return properties.getProperty(config);
    }
}


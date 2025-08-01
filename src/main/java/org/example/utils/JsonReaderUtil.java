package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReaderUtil {
    public static <T> T getPayloadJsonFileAsPOJO(String fileName, Class<T> clazz) {
        try {
            String filePath = "src/test/resources/apiRequest/" + fileName+".json";
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            return new ObjectMapper().readValue(json, clazz);  // Jackson is used here
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + fileName, e);
        }
    }
}

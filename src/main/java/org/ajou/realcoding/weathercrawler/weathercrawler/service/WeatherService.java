package org.ajou.realcoding.weathercrawler.weathercrawler.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class WeatherService {
    List<string> cities = null;
    @Autowired
    ObjectMapper objectMapper;

    public List<String> loadAvailableCityNamesFromFile() throws IOException {
        File file = new File("availableCityName");
        return objectMapper.readValue(file, new TypeReference<List<String>>(){});
    }
}

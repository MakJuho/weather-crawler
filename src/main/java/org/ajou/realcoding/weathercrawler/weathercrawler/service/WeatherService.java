package org.ajou.realcoding.weathercrawler.weathercrawler.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ajou.realcoding.weathercrawler.weathercrawler.api.OpenWeatherMapApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class WeatherService {
    List<String> cities = null;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    OpenWeatherMapApiClient openWeatherMapApiClient;

    @PostConstruct
    public void loadAvailableCityNamesFromFile() throws IOException {
        File file = new File("availableCityName");
        objectMapper.readValue(file, new TypeReference<List<String>>(){});
    }

    public List<String> getAvailableCities(){
        return cities;
    }

    public String getCurrentWeatherByCityName(String cityName){
        return openWeatherMapApiClient.requestCurrentWeather(cityName);
    }
}

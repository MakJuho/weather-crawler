package org.ajou.realcoding.weathercrawler.weathercrawler.api;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {

    private final String appid = "25c32c6caef355bf14466dd61b8be4ce";
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={appid}";

    @Autowired
    RestTemplate restTemplate;

    public CurrentWeather requestCurrentWeather(String cityName){
        // Params : Url, Method, Header, return type, {} params
        return restTemplate.exchange(openWeatherUrl, HttpMethod.GET, null, CurrentWeather.class, cityName, appid)
                .getBody();
    }

}

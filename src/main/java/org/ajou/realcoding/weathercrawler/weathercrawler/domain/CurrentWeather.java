package org.ajou.realcoding.weathercrawler.weathercrawler.domain;

import lombok.Data;

import java.util.List;

@Data
public class CurrentWeather {

    private String name;
    private int dt;
    private String base;
    private int visibility;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Others sys;

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class Main {
        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;
    }

    @Data
    public static class Wind {
        private double speed;
        private int deg;
    }

    @Data
    public static class Clouds {
        private int all;
    }

    @Data
    public static class Others {
        private String country;
        private double message;
        private long sunrise;
        private long sunset;
    }
}
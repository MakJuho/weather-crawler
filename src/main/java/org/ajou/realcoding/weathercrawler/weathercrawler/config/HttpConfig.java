package org.ajou.realcoding.weathercrawler.weathercrawler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 스피링한테 객체화 시켜달라고 요청
@Configuration
public class HttpConfig {

    @Bean
    public RestTemplate createRestTemplate(){

        return new RestTemplate();
    }
}

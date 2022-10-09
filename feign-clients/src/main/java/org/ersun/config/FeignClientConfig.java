package org.ersun.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }

}

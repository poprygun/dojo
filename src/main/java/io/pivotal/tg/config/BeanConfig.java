package io.pivotal.tg.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @LoadBalanced
    @Bean
    @Profile(value = "cloud")
    RestTemplate restTemplateLb() {
        return new RestTemplate();
    }

    @Bean
    @Profile(value = "!cloud")
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

package com.xyauto.interact.broker.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableAsync
public class App extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        setRegisterErrorPageFilter(false);
        return application.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }



}

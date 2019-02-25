package com.upload.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class Configurations extends WebMvcConfigurationSupport {


    @Value("${file.staticAccessPath}")
    private String pathPatterns;
    @Value("${file.uploadFolder}")
    private String locations;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(pathPatterns).addResourceLocations(locations);
        super.addResourceHandlers(registry);
    }

}

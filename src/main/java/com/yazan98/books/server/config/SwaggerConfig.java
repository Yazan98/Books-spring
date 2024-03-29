package com.yazan98.books.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 8:53 AM
 */


@Configuration
//@EnableSwagger2
@EnableAutoConfiguration
//@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yazan98.books.server.controller"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Books REST API",
                "API For Manage Android Application",
                "1.0.0",
                "Terms of service",
                new Contact("YT98", "", "yazantarifi1@hotmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}

package com.yazan98.books.server;

import com.yazan98.books.server.config.ApplicationProperties;
import com.yazan98.books.server.config.RequestResponseLoggingInterceptor;
import org.apache.commons.lang.StringUtils;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@EnableJSONDoc
@EnableCaching
@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableConfigurationProperties({LiquibaseProperties.class, ApplicationProperties.class})
public class BooksApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BooksApplication.class);
    }

    private static Logger log;

    public BooksApplication() {
        log = LoggerFactory.getLogger(BooksApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BooksApplication.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        configRestTemplate();

    }

    private static void configRestTemplate() {
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
    }

    private static void startPage(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port", "8090");
        String hostAddress = env.getProperty("server.address", "localhost");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://" + hostAddress + ":{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Api Page :\t " + protocol + "://" + hostAddress + ":" + serverPort + "/swagger-ui.html" + "\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles());

//        try {
//            startPage("http" + "://" + hostAddress + ":" + serverPort + "/jsondoc-ui.html");
////            startPage(protocol + "://" + hostAddress + ":" + serverPort + "/swagger-ui.html");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

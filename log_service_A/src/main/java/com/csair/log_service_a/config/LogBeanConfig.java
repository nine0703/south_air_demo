package com.csair.log_service_a.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogBeanConfig {

    @Bean
    public Logger rootLogger() {
        return LogManager.getLogger();
    }

//    @Bean
//    public Logger fileA() {
//        return LogManager.getLogger("fileA");
//    }
//
//    @Bean
//    public Logger fileB() {
//        return LogManager.getLogger("fileB");
//    }


}
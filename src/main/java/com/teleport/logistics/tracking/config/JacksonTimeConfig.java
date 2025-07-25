package com.teleport.logistics.tracking.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class JacksonTimeConfig {

    @Bean
    public Module zonedDateTimeModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ZonedDateTime.class, new FlexibleZonedDateTimeDeserializer());
        return module;
    }
}

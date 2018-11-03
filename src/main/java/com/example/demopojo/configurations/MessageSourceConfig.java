package com.example.demopojo.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasenames("i18n/index/index", "messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

}

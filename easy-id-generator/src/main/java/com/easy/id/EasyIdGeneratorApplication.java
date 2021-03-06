package com.easy.id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Abo
 */
@SpringBootApplication
@EnableConfigurationProperties
public class EasyIdGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyIdGeneratorApplication.class, args);
    }
}

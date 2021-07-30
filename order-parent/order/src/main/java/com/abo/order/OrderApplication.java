package com.abo.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

/**
 * @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
 *      排除SpringBoot自己的数据源自动配置类，使用自己定义的自动配置 DSAutoConfiguration
 * @author Abo
 */

@EnableFeignClients
@MapperScan("com.abo.order.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}

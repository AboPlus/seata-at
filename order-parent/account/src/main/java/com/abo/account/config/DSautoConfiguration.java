package com.abo.account.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置数据源代理对象
 * @author Abo
 */
@Configuration
public class DSautoConfiguration {
    // 创建原始的数据源对象
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new HikariDataSource();
    }

    // 创建数据源代理对象
    @Primary    // 首选对象
    @Bean
    public DataSource dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }
}

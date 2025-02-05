package com.cloudnativeplayground.healthcare.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName(dbDriverClassName);
        return dataSource;
    }
}

     /*The  DataSourceConfig  class is annotated with  @Configuration  to indicate that it is a configuration class. The  dataSource()  method is annotated with  @Bean  to indicate that it is a Spring bean. The method creates a  DriverManagerDataSource  object and sets the database URL, username, password, and driver class name.
     The values for the database URL, username, password, and driver class name are read from the application.properties file using the  @Value  annotation.
     Step 4: Create a JdbcTemplate Bean
     The  JdbcTemplate  class in Spring is a JDBC abstraction that simplifies database access. It eliminates the need for boilerplate code to open and close connections, create and execute statements, and handle exceptions.
     Create a new class named  JdbcTemplateConfig  in the  com.cloudnativeplayground.healthcare.config  package and add the following code:*/
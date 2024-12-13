package com.xworkz.admin.configuratiion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.xworkz.admin")
@EnableWebMvc

public class AdminConfiguration {

    AdminConfiguration(){
        System.out.println("running AdminConfiguration");
    }


}

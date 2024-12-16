package com.xworkz.login.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.login")
@EnableWebMvc
public class LoginConfiguration {

    LoginConfiguration(){
        System.out.println("running LoginConfiguration");
    }

}

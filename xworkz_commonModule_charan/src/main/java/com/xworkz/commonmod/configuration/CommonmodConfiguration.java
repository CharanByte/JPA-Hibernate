package com.xworkz.commonmod.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.commonmod")
public class CommonmodConfiguration {
    CommonmodConfiguration(){
        System.out.println("running CommonmodConfiguration ");
    }
}

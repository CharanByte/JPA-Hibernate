package com.xworkz.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.xworkz.project")
@EnableWebMvc
public class ProjectConfiguration {

    ProjectConfiguration(){
        System.out.println("ProjectConfiguration");
    }

//    @Bean
//  public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setPackagesToScan("com.xworkz.project.entity");
//        bean.setDataSource(dataSource());
//        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//    return bean;
//    }
//@Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/signup_db");
//        driverManagerDataSource.setUsername("root");
//        driverManagerDataSource.setPassword("charan");
//        return  driverManagerDataSource;
//    }
}

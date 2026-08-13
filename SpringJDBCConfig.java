package com.springboot.springbootcallingexternalapi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJDBCConfig {
	 @Bean public DataSource mysqlDataSource() {
		 
		 DriverManagerDataSource datasource = new DriverManagerDataSource();
		 datasource.setDriverClassName("com.mysql.jdbc.driver");
		 datasource.setUrl("jdbc:mysql://localhost:8800/employee_management_system");
		 datasource.setUsername("root");
		 datasource.setPassword("mina0117witchwaka");
		 return datasource;
	 }

}

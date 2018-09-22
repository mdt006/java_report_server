package com.ds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.ds.init.ApplicationStartup;


@SpringBootApplication
@MapperScan(basePackages={"com.ds","com.kg.live"})
@EnableScheduling
public class Main {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Main.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
	}
}

package com.ds.lmg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages={"com.ds","com.kg.live"})
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}

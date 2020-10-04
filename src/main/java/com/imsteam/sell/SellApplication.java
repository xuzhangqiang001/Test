package com.imsteam.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.imsteam.sell.dao")
@SpringBootApplication
@MapperScan(value = {"com.imsteam.sell.dao"})
public class SellApplication {
	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}

}

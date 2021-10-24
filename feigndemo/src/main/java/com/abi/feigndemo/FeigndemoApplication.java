package com.abi.feigndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "rest-product")
@EnableFeignClients
@SpringBootApplication
public class FeigndemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeigndemoApplication.class, args);
	}

}

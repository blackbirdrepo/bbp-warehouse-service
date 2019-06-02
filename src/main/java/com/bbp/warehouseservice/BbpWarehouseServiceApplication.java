package com.bbp.warehouseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Optional;

//TODO
//logging
//ControllerAdvice

//Validation
//tree
//Security with user auditing
//PatchMethods(partial update)
//SoftDelete
//HATEOAS
@EnableEurekaClient
@SpringBootApplication
public class BbpWarehouseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbpWarehouseServiceApplication.class, args);
	}

}

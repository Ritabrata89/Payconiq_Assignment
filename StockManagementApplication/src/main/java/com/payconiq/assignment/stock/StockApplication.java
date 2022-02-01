package com.payconiq.assignment.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * The main class of the application.
 * @author rtbrt2009@gmail.com
 *
 */

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Stock API", version="1.0", description = "Stock microservice"))
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}

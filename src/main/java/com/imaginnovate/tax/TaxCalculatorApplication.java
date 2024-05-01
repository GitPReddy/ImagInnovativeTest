package com.imaginnovate.tax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaxCalculatorApplication {

	public static void main(String[] args) {
		System.out.println("Tax calculator application");
		SpringApplication.run(TaxCalculatorApplication.class, args);
	}

}

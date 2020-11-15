package com.imm.report.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class InvoiceGeneratorApplication  {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceGeneratorApplication.class, args);
	}
}

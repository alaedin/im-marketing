package com.imm.documentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author alaeddine
 *
 */
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class DocumentationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentationAppApplication.class, args);
	}
}

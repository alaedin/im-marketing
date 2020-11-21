package com.imm.marketings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ImMarketingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImMarketingsApplication.class, args);
	}


//	   @Bean
//	   public RestTemplate restTemplate(RestTemplateBuilder builder) {
//	      return builder.build();
//	   }
//	   
}

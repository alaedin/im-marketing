package com.imm.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.cloud.config.server.git.uri",
				System.getProperty("user.dir") + "/" + "im-configuration");

		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

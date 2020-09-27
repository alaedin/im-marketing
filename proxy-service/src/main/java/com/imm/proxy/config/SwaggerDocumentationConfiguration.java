package com.imm.proxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfiguration {


	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Proxy documentation")
				.description(
						"centalized documentation")
				.termsOfServiceUrl("").version("0.0.1-SNAPSHOT")
				.build();
	}

	@Bean
	public Docket configureControllerPackageAndConvertors() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.imm.proxy.controller")).build()
	                .apiInfo(apiInfo());
	}

}

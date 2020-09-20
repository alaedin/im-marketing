package com.imm.documentation.config.swagger;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

/**
 * 
 * @author alaeddine
 * <pre>
 * 	Get the name of this application to not be shown in Swagger service list.
 *	We can also add all variable from bootstrap.yml or application.yml.
 * </pre>
 * 
 */
@Data
public class SwaggerProvider {

	@Value(value = "${spring.application.name}")
	private String applicationName;
}

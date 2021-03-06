package com.imm.documentation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.imm.documentation.config.swagger.ServiceDefinitionsContext;

/**
 * 
 * @author alaeddine
 * <pre>
 *  Controller to serve the JSON from our in-memory store. So that UI can render the API-Documentation	
 * </pre>
 */
@RestController
public class ServiceDefinitionController {
	
	@Autowired
	private ServiceDefinitionsContext definitionContext;
	
	@GetMapping("/service/{servicename}")
	public String getServiceDefinition(@PathVariable("servicename") String serviceName){
		
		return definitionContext.getSwaggerDefinition(serviceName);
		
	}
}

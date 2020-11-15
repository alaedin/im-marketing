package com.imm.report.generator.feign.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "im-marketings")
@RibbonClient(name= "im-marketings")
@RequestMapping("/im-workspace")
public interface PersonClient {
	
	static final String BASED_PATH = "/appointment";

	@GetMapping(BASED_PATH + "/person/{personId}")
	ResponseEntity<?>  getByPerson(@PathVariable("personId") Long personId);

}

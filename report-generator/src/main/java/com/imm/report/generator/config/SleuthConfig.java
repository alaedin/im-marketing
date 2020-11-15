package com.imm.report.generator.config;

import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

//@Configuration
public class SleuthConfig {

	
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}

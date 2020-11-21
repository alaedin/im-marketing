package com.imm.marketings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.PathMappedEndpoints;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActuatorLogger {

  public ActuatorLogger(@Autowired PathMappedEndpoints pme) {
    log.info("Actuator base path: {}", pme.getBasePath());
    pme.getAllPaths().forEach(p -> log.info("Path: {}", p));
  }
}
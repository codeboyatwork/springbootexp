package com.experiment.demo.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.experiment.demo.controller.SimpleCalculatorController;
import com.experiment.demo.serviceimpl.CalculatorService;

@SpringBootTest
class SimpleCalculatorContextLoadTests {
	
	@Autowired
	private SimpleCalculatorController  controller;
	
	@Autowired
	private CalculatorService service;
	
	@Test
	public void contextLoadsCalculatorControllerBean() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void contextLoadsCalculatorServiceBean() throws Exception {
		assertThat(service).isNotNull();
	}
	
}

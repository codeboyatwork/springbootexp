package com.experiment.demo.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.experiment.demo.controller.SimpleCalculatorController;
import com.experiment.demo.serviceimpl.CalculatorService;
import com.experiment.demo.serviceimpl.WordService;

@SpringBootTest
class SimpleCalculatorContextLoadTests {
	
	@Autowired
	private SimpleCalculatorController  controller;
	
	@Autowired
	private CalculatorService service;
	
	@Autowired
	private WordService wordService;
	
	@Test
	void contextLoadsCalculatorControllerBean() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	void contextLoadsCalculatorServiceBean() throws Exception {
		assertThat(service).isNotNull();
	}
	
	@Test
	void contextLoadsWordServiceBean() throws Exception {
		assertThat(wordService).isNotNull();
	}
	
}

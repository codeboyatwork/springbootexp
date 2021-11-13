package com.experiment.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.demo.model.InputEntity;
import com.experiment.demo.model.OutputEntity;
import com.experiment.demo.serviceimpl.CalculatorService;

@RestController
public class SimpleCalculatorController {
	@Autowired
	CalculatorService calculatorService;

	public static final Logger logger = LoggerFactory.getLogger(SimpleCalculatorController.class);

	private static final String AND = "and";
	private static final String IS = "is";

	@PostMapping("/addition")
	public ResponseEntity<Object> performAddition(@RequestBody InputEntity inputEntity) {
		long a = inputEntity.getA();
		long b = inputEntity.getB();
		long c = calculatorService.add(a, b);
		logger.info("Addition of {} {} {} {} {}", a, AND, b, IS, c);
		OutputEntity output = new OutputEntity();
		output.setAnswer(c);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@PostMapping("/subtraction")
	public ResponseEntity<Object> performSubtraction(@RequestBody InputEntity inputEntity) {
		long a = inputEntity.getA();
		long b = inputEntity.getB();
		long c = calculatorService.subtract(a, b);
		logger.info("Subtraction of {} {} {} {} {}", a, AND, b, IS, c);
		OutputEntity output = new OutputEntity();
		output.setAnswer(c);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@PostMapping("/multiplication")
	public ResponseEntity<Object> performMultiplication(@RequestBody InputEntity inputEntity) {
		long a = inputEntity.getA();
		long b = inputEntity.getB();
		long c = calculatorService.multiply(a, b);
		logger.info("Multiplication of {} {} {} {} {}", a, AND, b, IS, c);
		OutputEntity output = new OutputEntity();
		output.setAnswer(c);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@PostMapping("/division")
	public ResponseEntity<Object> performDivision(@RequestBody InputEntity inputEntity) {
		long a = inputEntity.getA();
		long b = inputEntity.getB();
		long c = calculatorService.divide(a, b);
		logger.info("Division of {} {} {} {} {}", a, AND, b, IS, c);
		OutputEntity output = new OutputEntity();
		output.setAnswer(c);
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}

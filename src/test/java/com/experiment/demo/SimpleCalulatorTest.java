package com.experiment.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.experiment.demo.serviceimpl.CalculatorService;

public class SimpleCalulatorTest {
	
	CalculatorService service = new CalculatorService();

	@Test
	void testAdd()
	{
		assertEquals(5,service.add(3, 2));
	}
	
	@Test
	void testSubtract()
	{
		assertEquals(1,service.subtract(3, 2));
	}
	
	@Test
	void testMultiply()
	{
		assertEquals(6,service.multiply(3, 2));
	}
	
	@Test
	void testDivide()
	{
		assertEquals(1,service.divide(5, 5));
	}
	
	@Test
	void testDivideByZeroError()
	{
		assertThrows(ArithmeticException.class, () -> {service.divide(5, 0);});
	}
}

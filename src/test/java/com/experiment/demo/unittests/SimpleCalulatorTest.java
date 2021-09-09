package com.experiment.demo.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.experiment.demo.serviceimpl.CalculatorService;
import com.experiment.demo.testbase.ProvideIntsForAddition;
import com.experiment.demo.testbase.ProvideIntsForMultiplication;
import com.experiment.demo.testbase.ProvideIntsForSubtraction;

public class SimpleCalulatorTest {
	
	CalculatorService service = new CalculatorService();

	@ParameterizedTest
	@ArgumentsSource(ProvideIntsForAddition.class)
	void testAdd(int a,int b, int c)
	{
		assertEquals(c,service.add(a, b));
	}
	
	@ParameterizedTest
	@ArgumentsSource(ProvideIntsForSubtraction.class)
	void testSubtract(int a,int b, int c)
	{
		assertEquals(c,service.subtract(a, b));
	}
	
	@ParameterizedTest
	@ArgumentsSource(ProvideIntsForMultiplication.class)
	void testMultiply(int a,int b, int c)
	{
		assertEquals(c,service.multiply(a, b));
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

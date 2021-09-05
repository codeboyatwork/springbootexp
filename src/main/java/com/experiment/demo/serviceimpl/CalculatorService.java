package com.experiment.demo.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int add(int a, int b) {
		return a+b;
	}
	
	public int subtract(int a, int b) {
		return a-b;
	}
	
	public int divide(int a, int b) {
		try {
		return a/b;
		}
		catch(ArithmeticException e)
		{
			throw e;
		}
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}
}

package com.experiment.demo.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public long add(long a, long b) {
		return a+b;
	}
	
	public long subtract(long a, long b) {
		return a-b;
	}
	
	public long divide(long a, long b) {
		try {
		return a/b;
		}
		catch(ArithmeticException e)
		{
			throw e;
		}
	}
	
	public long multiply(long a, long b) {
		return a*b;
	}
}

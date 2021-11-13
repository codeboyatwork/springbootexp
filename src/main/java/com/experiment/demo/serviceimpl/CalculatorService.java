package com.experiment.demo.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	Logger logger = LoggerFactory.getLogger(CalculatorService.class);

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
			logger.error("Divide by Zero Error");
			throw e;
		}
	}
	
	public long multiply(long a, long b) {
		return a*b;
	}
}

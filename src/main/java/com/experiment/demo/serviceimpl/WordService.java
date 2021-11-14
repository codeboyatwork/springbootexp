package com.experiment.demo.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WordService {

	Logger logger = LoggerFactory.getLogger(WordService.class);
	
	public String upperCase(String a) {
		return a.toUpperCase();
	}
	
	public String lowerCase(String a) {
		return a.toLowerCase();
	}
	
}

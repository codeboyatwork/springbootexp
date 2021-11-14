package com.experiment.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.demo.model.InputWordEntity;
import com.experiment.demo.model.OutputWordEntity;
import com.experiment.demo.serviceimpl.WordService;

@RestController
public class WordController {
	@Autowired
	WordService wordService;

	public static final Logger logger = LoggerFactory.getLogger(WordController.class);
	
	private static final String IS = "is";
	
	@PostMapping("/word/uppercase")
	public ResponseEntity<Object> performUpperCase(@RequestBody InputWordEntity word) {
		String upperCaseWord = wordService.upperCase(word.getWord());
		logger.info("Uppercase of {} {} {}", word.getWord(), IS, upperCaseWord);
		return new ResponseEntity<>(new OutputWordEntity(upperCaseWord), HttpStatus.OK);
	}
	
	@PostMapping("/word/lowercase")
	public ResponseEntity<Object> performLowerCase(@RequestBody InputWordEntity word) {
		String lowerCaseWord = wordService.lowerCase(word.getWord());
		logger.info("Lowercase of {} {} {}", word.getWord(), IS, lowerCaseWord);
		return new ResponseEntity<>(new OutputWordEntity(lowerCaseWord), HttpStatus.OK);
	}
}

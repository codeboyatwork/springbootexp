package com.experiment.demo.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.experiment.demo.serviceimpl.WordService;

class WordServiceTest {

	WordService service = new WordService();
	private static final String WORD_TO_TEST = "test_123";

	@Test
	void testUpperCase()
	{
		assertEquals(WORD_TO_TEST.toUpperCase(),service.upperCase(WORD_TO_TEST));
	}
	
	@Test
	void testLowerCase()
	{
		assertEquals(WORD_TO_TEST.toLowerCase(),service.lowerCase(WORD_TO_TEST));
	}
}

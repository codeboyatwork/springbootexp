package com.experiment.demo.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.experiment.demo.model.InputWordEntity;
import com.experiment.demo.model.OutputWordEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WordServiceIntegrationTests {

	private final String BASE_URL = "http://localhost:";
	private static final String WORD_TO_TEST = "test_123";
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testUpperCase() throws Exception {
		String endpoint = "/word/uppercase";
		InputWordEntity entity = new InputWordEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setWord(WORD_TO_TEST);
		ResponseEntity<OutputWordEntity> response = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputWordEntity.class);
		assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		String answer = response.getBody().getWord();
		assertEquals(WORD_TO_TEST.toUpperCase(),answer);
	}
	
	@Test
	void testLowerCase() throws Exception {
		String endpoint = "/word/lowercase";
		InputWordEntity entity = new InputWordEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setWord(WORD_TO_TEST);
		ResponseEntity<OutputWordEntity> response = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputWordEntity.class);
		assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		String answer = response.getBody().getWord();
		assertEquals(WORD_TO_TEST.toLowerCase(),answer);
	}
}

package com.experiment.demo.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.experiment.demo.model.InputEntity;
import com.experiment.demo.model.OutputEntity;
import com.experiment.demo.testbase.ProvideIntsForAddition;
import com.experiment.demo.testbase.ProvideIntsForMultiplication;
import com.experiment.demo.testbase.ProvideIntsForSubtraction;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SimpleCalculatorIntegrationTests {
	
	private final String BASE_URL = "http://localhost:";

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@ParameterizedTest
	@ArgumentsSource(ProvideIntsForAddition.class)
	public void testAdd(int a, int b, int c) throws Exception {
		String endpoint = "/addition";
		InputEntity entity = new InputEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setA(a);
		entity.setB(b);
		ResponseEntity<OutputEntity> response = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputEntity.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
		int answer = response.getBody().getAnswer();
		assertEquals(c,answer);
	}
	
	@ParameterizedTest
	@ArgumentsSource(ProvideIntsForSubtraction.class)
	void testSubtract(int a,int b, int c)
	{
		String endpoint = "/subtraction";
		InputEntity entity = new InputEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setA(a);
		entity.setB(b);
		ResponseEntity<OutputEntity> response = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputEntity.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
		int answer = response.getBody().getAnswer();
		assertEquals(c,answer);
	}
	
	@ParameterizedTest
	@ArgumentsSource(ProvideIntsForMultiplication.class)
	void testMultiply(int a,int b, int c)
	{
		String endpoint = "/multiplication";
		InputEntity entity = new InputEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setA(a);
		entity.setB(b);
		ResponseEntity<OutputEntity> response = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputEntity.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
		int answer = response.getBody().getAnswer();
		assertEquals(c,answer);
	}
	
	@Test
	void testDivide()
	{
		String endpoint = "/division";
		InputEntity entity = new InputEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setA(5);
		entity.setB(5);
		ResponseEntity<OutputEntity> response = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputEntity.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		assertEquals(response.getHeaders().getContentType(), MediaType.APPLICATION_JSON);
		int answer = response.getBody().getAnswer();
		assertEquals(1,answer);	
	}
	
	@Test
	void testDivideByZeroError()
	{
		String endpoint = "/division";
		InputEntity entity = new InputEntity();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity.setA(5);
		entity.setB(0);
		ResponseEntity<OutputEntity> response  = this.restTemplate.postForEntity(BASE_URL + port + endpoint, entity, OutputEntity.class);
		assertThat(response.getStatusCode().is5xxServerError());
	}
	
}

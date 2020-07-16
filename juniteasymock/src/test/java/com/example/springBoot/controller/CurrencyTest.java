package com.example.springBoot.controller;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.isA;

import java.io.IOException;

public class CurrencyTest extends TestCase {
	
	@Test
	public void testToEuros() throws IOException {
		Currency expected = new Currency(3.75, "EUR");
		Currency testObject = new Currency(2.50, "USD");
		ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
		EasyMock.expect(mock.getRate("USD", "EUR")).andReturn(1.5);
		EasyMock.replay(mock);		
		Currency actual = testObject.toEuros(mock);
		assertEquals(expected, actual);
	}

	@Test
	public void testToEurosWithException() throws IOException {
		Currency expected = new Currency(3.75, "EUR");
		Currency testObject = new Currency(2.50, "USD");
		ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
		EasyMock.expect(mock.getRate("USD", "EUR")).andThrow(new IOException());
		EasyMock.replay(mock);
		Currency actual = testObject.toEuros(mock);
		assertNull(actual);
	}
	
	
	@Test
	public void testToEurosAny() throws IOException {
		Currency expected = new Currency(3.75, "EUR");
		Currency testObject = new Currency(2.50, "USD");
		ExchangeRate mock = EasyMock.createMock(ExchangeRate.class);
		EasyMock.expect(mock.getRate((String) EasyMock.anyObject(), (String) EasyMock.anyObject())).andReturn(1.5);
		EasyMock.replay(mock);
		Currency actual = testObject.toEuros(mock);
		assertEquals(expected, actual);
	}

}

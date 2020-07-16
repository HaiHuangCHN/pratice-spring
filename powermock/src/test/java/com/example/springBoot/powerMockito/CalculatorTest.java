package com.example.springBoot.powerMockito;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.springBoot.powerMockito.Calculator;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Calculator.class })
public class CalculatorTest {

	private Calculator test;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
	
	@Before
	public void setUp() throws Exception {

		test = new Calculator();

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testSumXX() throws Exception {

		Calculator powerMock = PowerMockito.spy(new Calculator());
		PowerMockito.when(powerMock, "sum", 1, 2).thenReturn(2);
		assertEquals(2, powerMock.callSum(1, 2));

	}

}
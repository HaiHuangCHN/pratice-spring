package com.example.springBoot.service;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.springBoot.dao.CustomerDao;
import com.example.springBoot.dto.Customer;
import com.example.springBoot.service.CustomerService;

import junit.framework.Assert;;

public class CustomerServiceTest {

	@Mock
	private CustomerDao daoMock;

	@InjectMocks
	private CustomerService service;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddCustomer_returnsNewCustomer() {

		when(daoMock.save((Customer) any(Customer.class))).thenReturn(new Customer());

		Customer customer = new Customer();

		Assert.assertNotNull(service.addCustomer(customer));

	}

}

package com.example.springBoot.dao;

import com.example.springBoot.dto.Customer;

public class CustomerDao {
	
	public boolean exists(String string) {

		if (string.equals("123456789")) {
			return true;
		}

		return false;

	}

	public Customer save(Customer customer) {
		return customer;
	}
}

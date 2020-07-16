package com.example.springBoot.service;

import com.example.springBoot.dao.CustomerDao;
import com.example.springBoot.dto.Customer;

public class CustomerService {

//	@Inject
	private CustomerDao customerDao = new CustomerDao();

	public Customer addCustomer(Customer customer) {

		if (customerDao.exists(customer.getPhone())) {
			System.out.println("This customer is already existed");
			return null;
		} else {
			return customerDao.save(customer);
		}
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}

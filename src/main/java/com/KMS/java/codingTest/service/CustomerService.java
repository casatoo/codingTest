package com.KMS.java.codingTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMS.java.codingTest.repository.CustomerRepository;
import com.KMS.java.codingTest.vo.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getCustomersData(int customerId, String customerName) {
		return customerRepository.getCustomersData(customerId,customerName);
	}
	
	public int getLastInsertId() {
		return customerRepository.getLastInsertId();
	}

	public int getCustomerCountData() {
		return customerRepository.getCustomerCountData();
	}

	public void createCustomerData(String customerName, String phoneNumber) {
		customerRepository.createCustomerData(customerName,phoneNumber);
		
	}

	public Customer getComapnyDataByCompanyId(int customerId) {
		return customerRepository.getComapnyDataByCompanyId(customerId);
	}

	public void modifyCustomerData(int customerId, String customerName, String phoneNumber) {
		customerRepository.modifyCustomerData(customerId,customerName,phoneNumber);
	}

	public Customer getCustomerDataByCustomerId(int customerId) {
		return customerRepository.getCustomerDataByCustomerId(customerId);
	}

}

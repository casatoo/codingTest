package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Customer;


@Mapper
public interface CustomerRepository {

	List<Customer> getCustomersData(int customerId, String customerName);

	int getCustomerCountData();
	
	int getLastInsertId();

	void createCustomerData(String customerName, String phoneNumber);

	Customer getComapnyDataByCompanyId(int customerId);

	void modifyCustomerData(int customerId, String customerName, String phoneNumber);

	Customer getCustomerDataByCustomerId(int customerId);

}
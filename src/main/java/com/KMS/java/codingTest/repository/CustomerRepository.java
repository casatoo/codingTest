package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Customer;


@Mapper
public interface CustomerRepository {

	List<Customer> getCustomersData(int customerId, String customerName);

	int getCustomerCountData();

}
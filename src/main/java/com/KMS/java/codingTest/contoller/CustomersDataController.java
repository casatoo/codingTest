package com.KMS.java.codingTest.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KMS.java.codingTest.service.CustomerService;
import com.KMS.java.codingTest.vo.Customer;
import com.KMS.java.codingTest.vo.ResultData;

@Controller
public class CustomersDataController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/usr/Customers/getCustomerData")
	@ResponseBody
	public <DT> ResultData<DT> getCustomerData(
			@RequestParam(defaultValue = "0")int customerId, 
			@RequestParam(defaultValue = "")String customerName
			) {
		
		int customerCount = customerService.getCustomerCountData();
		
		List<Customer> customer = customerService.getCustomersData(customerId,customerName);
		
		ResultData<DT> rd = ResultData.from(customerCount,customer);
		return rd;
	}
	

	
	@RequestMapping("/usr/Customers/createCustomerData")
	@ResponseBody
	public <DT> ResultData<DT> createCustomerData(String customerName,String phoneNumber) {
		
		customerService.createCustomerData(customerName,phoneNumber);
		
		int id = customerService.getLastInsertId();
		
		int customerCount = customerService.getCustomerCountData();
		
		Customer customer = customerService.getComapnyDataByCompanyId(id);
		
		ResultData<DT> rd = ResultData.from(customerCount,customer);	
		
		return rd;
	}
	
	@RequestMapping("/usr/Customers/modifyCustomerData")
	@ResponseBody
	public <DT> ResultData<DT> modifyCustomerData(
			int customerId,
			@RequestParam(defaultValue = "")String customerName,
			@RequestParam(defaultValue = "")String phoneNumber
			) {
		customerService.modifyCustomerData(customerId,customerName,phoneNumber);
		
		int customerCount = customerService.getCustomerCountData();
		
		Customer customer = customerService.getCustomerDataByCustomerId(customerId);
				
		ResultData<DT> rd = ResultData.from(customerCount,customer);	
		return rd;
	}
}

package com.KMS.java.codingTest.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KMS.java.codingTest.service.CompanyService;
import com.KMS.java.codingTest.service.CustomerService;
import com.KMS.java.codingTest.service.OrderService;
import com.KMS.java.codingTest.service.ProductService;
import com.KMS.java.codingTest.vo.Company;
import com.KMS.java.codingTest.vo.Customer;
import com.KMS.java.codingTest.vo.Order;
import com.KMS.java.codingTest.vo.Product;
import com.KMS.java.codingTest.vo.ResultData;

@Controller
public class CodingTestController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/usr/get/ProductsData")
	@ResponseBody
	public <DT> ResultData<DT> ProductsData(
			@RequestParam(defaultValue = "0")int productId,
			@RequestParam(defaultValue = "")String productName, 
			@RequestParam(defaultValue = "0")int companyId
			) {
		
		int productCount = productService.getProductCountData();
		
		List<Product> product = productService.getProductsData(productId,productName,companyId);
		ResultData<DT> rd = ResultData.from(productCount,product);
		return rd;
	}
	
	@RequestMapping("/usr/get/CompanysData")
	@ResponseBody
	public <DT> ResultData<DT> CompanysData(
			@RequestParam(defaultValue = "0")int companyId, 
			@RequestParam(defaultValue = "")String companyName, 
			@RequestParam(defaultValue = "")String ceoName
			) {
		
		int companyCount = companyService.getCompanyCountData();
		
		List<Company> company = companyService.getCompanysData(companyId,companyName,ceoName);
		
		ResultData<DT> rd = ResultData.from(companyCount,company);
		return rd;
	}
	
	@RequestMapping("/usr/get/CustomersData")
	@ResponseBody
	public <DT> ResultData<DT> CustomersData(
			@RequestParam(defaultValue = "0")int customerId, 
			@RequestParam(defaultValue = "")String customerName
			) {
		
		int customerCount = customerService.getCustomerCountData();
		
		List<Customer> customer = customerService.getCustomersData(customerId,customerName);
		
		ResultData<DT> rd = ResultData.from(customerCount,customer);
		return rd;
	}
	
	@RequestMapping("/usr/get/OrdersData")
	@ResponseBody
	public <DT> ResultData<DT> OrdersData(
			@RequestParam(defaultValue = "0")int orderId,
			@RequestParam(defaultValue = "0")int productId, 
			@RequestParam(defaultValue = "0")int customerId,
			@RequestParam(defaultValue = "")String customerName,
			@RequestParam(defaultValue = "")String productName,
			@RequestParam(defaultValue = "")String companyName
			) {
		
		int orderrCount = orderService.getOrderCountData();
		
		List<Order> order = orderService.getOrdersData(orderId,productId,customerId,customerName,productName,companyName);
		
		ResultData<DT> rd = ResultData.from(orderrCount,order);
		return rd;
	}
}

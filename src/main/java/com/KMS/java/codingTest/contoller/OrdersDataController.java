package com.KMS.java.codingTest.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KMS.java.codingTest.service.OrderService;
import com.KMS.java.codingTest.vo.Order;
import com.KMS.java.codingTest.vo.ResultData;

@Controller
public class OrdersDataController {
	
	@Autowired
	private OrderService orderService;

	
	@RequestMapping("/usr/Orders/getOrderData")
	@ResponseBody
	public <DT> ResultData<DT> getOrderData(
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
	
	@RequestMapping("/usr/Orders/createOrderData")
	@ResponseBody
	public <DT> ResultData<DT> createOrderData(int productId,int customerId,int payment,int quantity) {
		
		orderService.createOrderData(productId,customerId,payment,quantity);
		
		int id = orderService.getLastInsertId();
		
		int orderrCount = orderService.getOrderCountData();
		
		Order order = orderService.getOrderDataByOrderId(id);
		
		ResultData<DT> rd = ResultData.from(orderrCount,order);	
		
		return rd;
	}
	
	@RequestMapping("/usr/Orders/modifyOrderData")
	@ResponseBody
	public <DT> ResultData<DT> modifyOrderData(
			int orderId,
			@RequestParam(defaultValue = "0")int productId,
			@RequestParam(defaultValue = "0")int customerId,
			@RequestParam(defaultValue = "0")int payment,
			@RequestParam(defaultValue = "0")int quantity
			) {
		orderService.modifyOrderData(orderId,productId,customerId,payment,quantity);
		
		int orderrCount = orderService.getOrderCountData();
		
		List<Order> order = orderService.getOrdersData(orderId,productId,customerId,"","","");
				
		ResultData<DT> rd = ResultData.from(orderrCount,order);	
		return rd;
	}
}

package com.KMS.java.codingTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMS.java.codingTest.repository.OrderRepository;
import com.KMS.java.codingTest.vo.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> getOrdersData(int orderId, int productId,int customerId,String customerName,String productName,String companyName) {
		
		return orderRepository.getOrdersData(orderId,productId,customerId,customerName,productName,companyName);
	}

	public int getOrderCountData() {
		return orderRepository.getOrderCountData();
	}

	public void createOrderData(int productId, int customerId, int payment, int quantity) {
		orderRepository.createOrderData(productId,customerId,payment,quantity);
	}

	public int getLastInsertId() {
		return orderRepository.getLastInsertId();
	}

	public Order getOrderDataByOrderId(int orderId) {
		return orderRepository.getOrderDataByOrderId(orderId);
	}

	public void modifyOrderData(int orderId, int productId, int customerId, int payment, int quantity) {
		orderRepository.modifyOrderData(orderId,productId,customerId,payment,quantity);
		return ;
	}

}

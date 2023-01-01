package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Order;


@Mapper
public interface OrderRepository {

	List<Order> getOrdersData(int orderId, int productId,int customerId,String customerName,String productName,String companyName);

	int getOrderCountData();

	void createOrderData(int productId, int customerId, int payment, int quantity);

	int getLastInsertId();

	Order getOrderDataByOrderId(int orderId);

	void modifyOrderData(int orderId, int productId, int customerId, int payment, int quantity);

}
package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Order;


@Mapper
public interface OrderRepository {

	List<Order> getOrdersData(int orderId, int productId,int customerId,String customerName,String productName,String companyName);

	int getOrderCountData();

}
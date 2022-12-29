package com.KMS.java.codingTest.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private int orderId;
	private String regDate;
	private int payment;
	private int quantity;
	
	private String extra__customerName;
	private String extra__productName;
	private String extra__companyName;
	private int extra__price;
}

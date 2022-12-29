package com.KMS.java.codingTest.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int productId;
	private String productName;
	private int price;
	private String regDate;
	private int companyId;

	private String extra__companyName;
}

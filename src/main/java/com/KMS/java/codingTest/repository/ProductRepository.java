package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Product;


@Mapper
public interface ProductRepository {

	List<Product> getProductData(int productId, String productName, int companyId);

	int getProductCountData();

	void createProductData(String productName, int price, int companyId);

	int getLastInsertId();

	void modifyProductData(int productId, String productName, int price, int companyId);

	Product getProductDataByProductIdCompanyId(int productId,int companyId);
	
	Product getProductDataByProductId(int productId);
}
package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Product;


@Mapper
public interface ProductRepository {

	List<Product> getProductsData(int productId, String productName, int companyId);

	int getProductCountData();

}
package com.KMS.java.codingTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMS.java.codingTest.repository.ProductRepository;
import com.KMS.java.codingTest.vo.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProductsData(int productId, String productName, int companyId) {
		return productRepository.getProductsData(productId,productName,companyId);
	}

	public int getProductCountData() {
		return productRepository.getProductCountData();
	}

}

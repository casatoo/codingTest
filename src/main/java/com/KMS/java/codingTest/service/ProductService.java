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

	public List<Product> getProductData(int productId, String productName, int companyId) {
		return productRepository.getProductData(productId,productName,companyId);
	}

	public int getProductCountData() {
		return productRepository.getProductCountData();
	}

	public void createProductData(String productName, int price, int companyId) {
			productRepository.createProductData(productName,price,companyId);
		return ;
		
	}

	public int getLastInsertId() {
		return productRepository.getLastInsertId();
	}

	public void modifyProductData(int productId, String productName, int price, int companyId) {
		productRepository.modifyProductData(productId,productName,price,companyId);
		return;
	}

	public Product getProductDataByProductIdCompanyId(int productId,int companyId) {
		return productRepository.getProductDataByProductIdCompanyId(productId,companyId);
	}

	public Product getProductDataByProductId(int productId) {
		
		return productRepository.getProductDataByProductId(productId);
	}

}

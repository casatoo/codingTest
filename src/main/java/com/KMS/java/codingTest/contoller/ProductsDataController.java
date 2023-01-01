package com.KMS.java.codingTest.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KMS.java.codingTest.service.ProductService;
import com.KMS.java.codingTest.vo.Product;
import com.KMS.java.codingTest.vo.ResultData;

@Controller
public class ProductsDataController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/usr/products/getProductData")
	@ResponseBody
	public <DT> ResultData<DT> getProductData(
			@RequestParam(defaultValue = "0")int productId,
			@RequestParam(defaultValue = "")String productName, 
			@RequestParam(defaultValue = "0")int companyId
			) {
		
		int productCount = productService.getProductCountData();
		
		List<Product> product = productService.getProductData(productId,productName,companyId);
		ResultData<DT> rd = ResultData.from(productCount,product);
		return rd;
	}
	@RequestMapping("/usr/products/createProductData")
	@ResponseBody
	public <DT> ResultData<DT> createProductData(String productName,int price,int companyId) {
		
		productService.createProductData(productName,price,companyId);
		
		int id = productService.getLastInsertId();
		
		int productCount = productService.getProductCountData();
		
		Product product = productService.getProductDataByProductIdCompanyId(id,companyId);
		
		ResultData<DT> rd = ResultData.from(productCount,product);	
		
		return rd;
	}
	
	@RequestMapping("/usr/products/modifyProductData")
	@ResponseBody
	public <DT> ResultData<DT> modifyProductData(
			int productId,
			@RequestParam(defaultValue = "")String productName,
			@RequestParam(defaultValue = "0")int price,
			@RequestParam(defaultValue = "0")int companyId
			) {
		productService.modifyProductData(productId,productName,price,companyId);
		
		Product modifyProduct = productService.getProductDataByProductId(productId);
		
		int productCount = productService.getProductCountData();
		
		Product product = productService.getProductDataByProductIdCompanyId(productId,modifyProduct.getCompanyId());
				
		ResultData<DT> rd = ResultData.from(productCount,product);	
		return rd;
	}
}

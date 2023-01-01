package com.KMS.java.codingTest.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KMS.java.codingTest.service.CompanyService;
import com.KMS.java.codingTest.service.ProductService;
import com.KMS.java.codingTest.vo.Company;
import com.KMS.java.codingTest.vo.Product;
import com.KMS.java.codingTest.vo.ResultData;

@Controller
public class CompanysDataController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/usr/Companys/getCompanyData")
	@ResponseBody
	public <DT> ResultData<DT> getCompanyData(
			@RequestParam(defaultValue = "0")int companyId, 
			@RequestParam(defaultValue = "")String companyName, 
			@RequestParam(defaultValue = "")String ceoName
			) {
		
		int companyCount = companyService.getCompanyCountData();
		
		List<Company> company = companyService.getCompanyData(companyId,companyName,ceoName);
		
		ResultData<DT> rd = ResultData.from(companyCount,company);
		return rd;
	}
	
	@RequestMapping("/usr/Companys/createCompanyData")
	@ResponseBody
	public <DT> ResultData<DT> createCompanyData(String companyName,String ceoName,String phoneNumber) {
		
		companyService.createComapnyData(companyName,ceoName,phoneNumber);
		
		int id = companyService.getLastInsertId();
		
		int companyCount = companyService.getCompanyCountData();
		
		Company company = companyService.getComapnyDataByCompanyId(id);
		
		ResultData<DT> rd = ResultData.from(companyCount,company);	
		
		return rd;
	}
	
	@RequestMapping("/usr/Companys/modifyCompanyData")
	@ResponseBody
	public <DT> ResultData<DT> modifyCompanyData(
			int CompanyId,
			@RequestParam(defaultValue = "")String companyName,
			@RequestParam(defaultValue = "")String ceoName,
			@RequestParam(defaultValue = "")String phoneNumber
			) {
		companyService.modifyCompanyData(CompanyId,companyName,ceoName,phoneNumber);
		
		int companyCount = companyService.getCompanyCountData();
		
		Company company = companyService.getComapnyDataByCompanyId(CompanyId);
				
		ResultData<DT> rd = ResultData.from(companyCount,company);	
		return rd;
	}
}

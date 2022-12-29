package com.KMS.java.codingTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMS.java.codingTest.repository.CompanyRepository;
import com.KMS.java.codingTest.repository.ProductRepository;
import com.KMS.java.codingTest.vo.Company;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> getCompanysData(int companyId, String companyName, String ceoName) {
		
		return companyRepository.getCompanysData(companyId,companyName,ceoName);
	}

	public int getCompanyCountData() {
		return companyRepository.getCompanyCountData();
	}

}

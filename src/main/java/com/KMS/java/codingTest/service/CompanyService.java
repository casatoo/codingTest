package com.KMS.java.codingTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KMS.java.codingTest.repository.CompanyRepository;
import com.KMS.java.codingTest.vo.Company;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public List<Company> getCompanyData(int companyId, String companyName, String ceoName) {
		
		return companyRepository.getCompanyData(companyId,companyName,ceoName);
	}

	public int getCompanyCountData() {
		return companyRepository.getCompanyCountData();
	}

	public void createComapnyData(String companyName, String ceoName, String phoneNumber) {
		companyRepository.createComapnyData(companyName,ceoName,phoneNumber);
		return ;
	}

	public int getLastInsertId() {
		return companyRepository.getLastInsertId();
	}

	public Company getComapnyDataByCompanyId(int companyId) {		
		return companyRepository.getComapnyDataByCompanyId(companyId);
	}

	public void modifyCompanyData(int companyId, String companyName, String ceoName, String phoneNumber) {
		companyRepository.modifyCompanyData(companyId,companyName,ceoName,phoneNumber);
		return ;
		
	}

}

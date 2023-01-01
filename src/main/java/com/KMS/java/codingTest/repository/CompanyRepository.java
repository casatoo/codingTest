package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Company;


@Mapper
public interface CompanyRepository {

	List<Company> getCompanyData(int companyId, String companyName, String ceoName);

	int getCompanyCountData();

	void createComapnyData(String companyName, String ceoName, String phoneNumber);

	int getLastInsertId();

	Company getComapnyDataByCompanyId(int companyId);

	void modifyCompanyData(int companyId, String companyName, String ceoName, String phoneNumber);

}
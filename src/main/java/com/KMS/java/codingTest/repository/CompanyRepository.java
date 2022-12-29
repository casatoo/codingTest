package com.KMS.java.codingTest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.KMS.java.codingTest.vo.Company;


@Mapper
public interface CompanyRepository {

	List<Company> getCompanysData(int companyId, String companyName, String ceoName);

	int getCompanyCountData();

}
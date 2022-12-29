package com.KMS.java.codingTest.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	private int companyId;
	private String companyName;
	private String ceoName;
	private String phoneNumber;

}

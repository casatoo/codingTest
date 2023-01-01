package com.KMS.java.codingTest.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	
	@RequestMapping("/usr/home/main")
	public String ProductsData() {
		return "/usr/home/main";
	}
	
	
}

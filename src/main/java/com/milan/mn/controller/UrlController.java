package com.milan.mn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class UrlController {

	@GetMapping("/access-denied")
	public String accessdenied() {
		return "error_accessDenied";
	}
	
	@GetMapping("/app")
	public String home() {
		return "home";
	}
	
	@GetMapping("/app/addMasterTable")
	public String addMasterTable() {
		return "addMasterTable";
	}

	@GetMapping("/app/editMasterTable")
	public String editMasterTable() {
		return "editMasterTable";
	}

	@GetMapping("/app/masterTableList")
	public String masterTableList() {
		return "masterTableList";
	}
	
	
}

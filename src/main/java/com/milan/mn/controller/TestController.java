package com.milan.mn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milan.mn.model.MasterTable;
import com.milan.mn.service.MasterTableService;

@RestController
@RequestMapping("/app")
public class TestController {
	
	@Autowired
	MasterTableService masterTableService;

	@PostMapping("/save")
	public ResponseEntity<MasterTable> testController(@RequestBody MasterTable master) {
		return masterTableService.save(master);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<MasterTable>> findAll() {
		return masterTableService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Optional<MasterTable>> findById(@PathVariable int id) {
		return masterTableService.findById(id);
	}
	
	@GetMapping("/findDynamicTableNames")
	public Object findDynamicTableNames() {
		return masterTableService.findDynamicTableNames();
	}

}

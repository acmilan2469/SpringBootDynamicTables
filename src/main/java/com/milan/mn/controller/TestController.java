package com.milan.mn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milan.mn.dto.MasterTableInput;
import com.milan.mn.model.MasterTable;
import com.milan.mn.service.DynamicTableServices;
import com.milan.mn.service.MasterTableService;

@RestController
@RequestMapping("/app")
public class TestController {
	
	@Autowired
	MasterTableService masterTableService;
	
	@Autowired
	DynamicTableServices dynamicTableServices;

	@PostMapping("/save")
	public ResponseEntity<MasterTable> testController(@RequestBody MasterTableInput master) {
		return masterTableService.save(master);
	}

	@PostMapping("/test")
	public ResponseEntity<MasterTableInput> testC(@RequestBody MasterTableInput master) {
		System.out.println(master);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(master, headers, HttpStatus.CREATED);
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
	
	@GetMapping("/findDetailsFromTableName/{tableName}")
	public Object findDetailsFromTableName(@PathVariable String tableName) {
		return masterTableService.findDetailsFromTableName(tableName);
	}
	
	@PostMapping("/insertValueToTable/{tableName}")
	public void insertValueToTable(@RequestBody HashMap<String, Object> map, @PathVariable String tableName) {
		dynamicTableServices.insertValueToTable(map, tableName);
	}
	
	@GetMapping("/findAllValueFromTable/{tableName}")
	public Object findAllValueFromTable(@PathVariable String tableName) {
		return dynamicTableServices.findAllValueFromTable(tableName);
	}
	
	@GetMapping("/findValueFromTableGivenPK/{tableName}/{pk}")
	public Object findValueFromTableGivenPK(@PathVariable(value = "tableName") String tableName,@PathVariable(value = "pk") String pk) {
		return dynamicTableServices.findValueFromTableGivenPK(tableName, pk);
	}
	
	@PutMapping("/updateValueToTable/{tableName}/{pk}")
	public void updateValueToTable(@RequestBody HashMap<String, Object> map, @PathVariable(value = "tableName") String tableName,@PathVariable(value = "pk") String pk) {
		dynamicTableServices.updateValueToTable(map,tableName, pk);
	}
	

}

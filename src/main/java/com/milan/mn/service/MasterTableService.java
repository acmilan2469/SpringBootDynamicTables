package com.milan.mn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.milan.mn.dto.MasterTableInput;
import com.milan.mn.model.MasterTable;

public interface MasterTableService {
	
	public ResponseEntity<MasterTable> save(MasterTableInput masterTableInput);
	public ResponseEntity<List<MasterTable>> findAll();
	public ResponseEntity<Optional<MasterTable>> findById(int id);
	public ResponseEntity<HttpStatus> deleteById(int id);
	public ResponseEntity<MasterTable> update(MasterTable masterTable);
	public Object findDynamicTableNames();
}

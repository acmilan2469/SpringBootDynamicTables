package com.milan.mn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milan.mn.dto.MasterTableColumnDetailsInput;
import com.milan.mn.dto.MasterTableInput;
import com.milan.mn.model.MasterTable;
import com.milan.mn.model.MasterTableColumnDetails;
import com.milan.mn.model.MasterTableColumns;
import com.milan.mn.repos.MasterTableRepo;

@Service
@Transactional
public class MasterTableServiceImpl implements MasterTableService {

	@Autowired
	MasterTableRepo masterTableRepo;

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public ResponseEntity<MasterTable> save(MasterTableInput masterTableInput) {
		MasterTable masterTable = convertToMasterTable(masterTableInput);
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Master Table Successfully Saved and DynamicTable=");
			boolean builder = createTableDynamically(masterTable);
			stringBuilder.append(builder);
	
			MasterTable _masterTable = masterTableRepo.save(masterTable);
			HttpHeaders headers = new HttpHeaders();

			headers.add("header-msg", stringBuilder.toString());
			return new ResponseEntity<>(_masterTable, headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public MasterTable convertToMasterTable(MasterTableInput masterTableInput) {
		MasterTable masterTable = new MasterTable();
		masterTable.setTableName(masterTableInput.getTableName());
		masterTable.setNameOfMaster(masterTableInput.getNameOfMaster());
		masterTable.setActive(masterTableInput.isActive());
		masterTable.setApplicationRole(masterTableInput.getApplicationRole());
		masterTable.setDbType(masterTableInput.getDbType());

		List<MasterTableColumnDetails> columnDetailsList = new ArrayList<>();
		List<MasterTableColumns> columnsList = new ArrayList<>();
		
		for(MasterTableColumnDetailsInput detailsInput : masterTableInput.getMasterTableColumnDetails()) {
			MasterTableColumnDetails columnDetails = new MasterTableColumnDetails();
			MasterTableColumns columns = new MasterTableColumns();
			
			columns.setColumnName(detailsInput.getColumnName());
			columnDetails.setColumnName(detailsInput.getColumnName());
			
			columnDetails.setColumnDataType(detailsInput.getColumnDataType());
			columnDetails.setColumnMinLength(detailsInput.getColumnMinLength());
			columnDetails.setColumnMaxLength(detailsInput.getColumnMaxLength());
			columnDetails.setFieldType(detailsInput.getFieldType());
			columnDetails.setFieldText(detailsInput.getFieldText());
			columnDetails.setColumnValidations(detailsInput.getColumnValidations());
			columnDetails.setCustomValidations(detailsInput.getCustomValidations());
			columnDetails.setMandatory(detailsInput.isMandatory());
			columnDetails.setPrimaryKey(detailsInput.isPrimaryKey());
			
			columnDetailsList.add(columnDetails);
			columnsList.add(columns);
		}
		masterTable.setMasterTableColumnDetails(columnDetailsList);
		masterTable.setMasterTableColumns(columnsList);
		return masterTable;		
	}

	@Override
	public ResponseEntity<List<MasterTable>> findAll() {
		try {
			List<MasterTable> masterTables = new ArrayList<MasterTable>();

			masterTableRepo.findAll().forEach(masterTables::add);
			if (masterTables.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(masterTables, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Optional<MasterTable>> findById(int id) {
		 Optional<MasterTable> masterTableData = masterTableRepo.findById(id);

		    if (masterTableData.isPresent()) {
		      return new ResponseEntity<>(masterTableData, HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}

	@Override
	public ResponseEntity<HttpStatus> deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<MasterTable> update(MasterTable masterTable) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createTableDynamically(MasterTable masterTable) {
		StringBuilder createTableQuery = new StringBuilder(
				"CREATE TABLE " + masterTable.getTableName() + "(");

		StringBuilder primaryKey = new StringBuilder("");
		for (MasterTableColumnDetails details : masterTable.getMasterTableColumnDetails()) {
			createTableQuery.append(details.getColumnName() + " ");
			createTableQuery.append(details.getColumnDataType() + " ");
			createTableQuery.append(details.getColumnValidations() + ", ");		
			if (details.isPrimaryKey()) {
				primaryKey.append(addPrimaryKey(details.getColumnName()));
			}
		}
		createTableQuery.append(primaryKey);
		createTableQuery.append(")");

		EntityTransaction txn = null;
		try {
			EntityManager entityManager = emf.createEntityManager();
			txn = entityManager.getTransaction();
			txn.begin();
			entityManager.createNativeQuery(createTableQuery.toString()).executeUpdate();
			txn.commit();

			return true;
		} catch (Throwable e) {
			if (txn != null && txn.isActive()) {
				txn.rollback();
			}
			return false;
		}
	}

	public StringBuilder addPrimaryKey(String columnName) {
		// adding primary key
		StringBuilder primaryKey = new StringBuilder("PRIMARY KEY (");
		primaryKey.append(columnName);
		primaryKey.append(")");
		return primaryKey;
	}

	@Override
	public Object findDynamicTableNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findDetailsFromTableName(String tableName) {
		Optional<MasterTable> masterTable = masterTableRepo.findByTableName(tableName);
		List<MasterTableColumnDetailsInput> columnDetails = new ArrayList<>();
		
		for(MasterTableColumnDetails details : masterTable.get().getMasterTableColumnDetails()) {
			if (details.isPrimaryKey() == false) {
				MasterTableColumnDetailsInput masterTableColumnDetailsInput = new MasterTableColumnDetailsInput(); 
				masterTableColumnDetailsInput.setColumnName(details.getColumnName());
				masterTableColumnDetailsInput.setColumnDataType(details.getColumnDataType());
				masterTableColumnDetailsInput.setColumnMinLength(details.getColumnMinLength());
				masterTableColumnDetailsInput.setColumnMaxLength(details.getColumnMaxLength());
				masterTableColumnDetailsInput.setFieldType(details.getFieldType());
				masterTableColumnDetailsInput.setFieldText(details.getFieldText());
				masterTableColumnDetailsInput.setColumnValidations(details.getColumnValidations());
				masterTableColumnDetailsInput.setCustomValidations(details.getCustomValidations());
				masterTableColumnDetailsInput.setMandatory(details.isMandatory());
				masterTableColumnDetailsInput.setPrimaryKey(false);
				columnDetails.add(masterTableColumnDetailsInput);
			}			
		}
		return columnDetails;
	}

	

}

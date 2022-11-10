//package com.milan.mn.service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.milan.mn.model.MasterTable;
//import com.milan.mn.model.MasterTableDetails;
//import com.milan.mn.repos.MasterTableRepo;
//
//@Service
//@Transactional
//public class MasterTableServiceImpl implements MasterTableService {
//
//	@Autowired
//	MasterTableRepo masterTableRepo;
//
//	@PersistenceUnit
//	private EntityManagerFactory emf;
//
//	@Override
//	public ResponseEntity<MasterTable> save(MasterTable masterTable) {
//		try {
//			StringBuilder stringBuilder = new StringBuilder();
//			stringBuilder.append("Master Table Successfully Saved and DynamicTable=");
//			boolean builder = testTable(masterTable);
//			stringBuilder.append(builder);
//
//			masterTable.setDynamicTableCreated(builder);
//			MasterTable _masterTable = masterTableRepo.save(masterTable);
//			HttpHeaders headers = new HttpHeaders();
//
//			headers.add("header-msg", stringBuilder.toString());
//			return new ResponseEntity<>(_masterTable, headers, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@Override
//	public ResponseEntity<List<MasterTable>> findAll() {
//		try {
//			List<MasterTable> masterTables = new ArrayList<MasterTable>();
//
//			masterTableRepo.findAll().forEach(masterTables::add);
//			if (masterTables.isEmpty()) {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//
//			return new ResponseEntity<>(masterTables, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@Override
//	public ResponseEntity<Optional<MasterTable>> findById(int id) {
//		 Optional<MasterTable> masterTableData = masterTableRepo.findById(id);
//
//		    if (masterTableData.isPresent()) {
//		      return new ResponseEntity<>(masterTableData, HttpStatus.OK);
//		    } else {
//		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		    }
//	}
//
//	@Override
//	public ResponseEntity<HttpStatus> deleteById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ResponseEntity<MasterTable> update(MasterTable masterTable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean testTable(MasterTable masterTable) {
//		StringBuilder createTableQuery = new StringBuilder(
//				"CREATE TABLE IF NOT EXISTS `" + masterTable.getTableName() + "` (");
//
//		StringBuilder primaryKey = new StringBuilder("");
//		for (MasterTableDetails details : masterTable.getMasterTableDetails()) {
//			createTableQuery.append("`" + details.getColumnName() + "` ");
//			createTableQuery.append(details.getColumnType() + " ");
//			createTableQuery.append(details.getConstraints() + ", ");
//			if (details.isPrimaryKey()) {
//				primaryKey.append(addPrimaryKey(details.getColumnName()));
//			}
//		}
//		createTableQuery.append(primaryKey);
//		createTableQuery.append(")");
//
//		EntityTransaction txn = null;
//		try {
//			EntityManager entityManager = emf.createEntityManager();
//			txn = entityManager.getTransaction();
//			txn.begin();
//			entityManager.createNativeQuery(createTableQuery.toString()).executeUpdate();
//			txn.commit();
//
//			return true;
//		} catch (Throwable e) {
//			if (txn != null && txn.isActive()) {
//				txn.rollback();
//			}
//			return false;
//		}
//	}
//
//	public StringBuilder addPrimaryKey(String columnName) {
//		// adding primary key
//		StringBuilder primaryKey = new StringBuilder("PRIMARY KEY (`");
//		primaryKey.append(columnName);
//		primaryKey.append("`)");
//		return primaryKey;
//	}
//
//	@Override
//	public Object findDynamicTableNames() {
//		List<MasterTable> masterTables = masterTableRepo.findByDynamicTableCreated(true);
//		
//		List<Map<String, Object>> obj = new ArrayList<>();
//				
//		for (MasterTable master : masterTables) {
//			List<Map<String, Object>> childObj = new ArrayList<>();
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("TableName", master.getTableName());
//			for (MasterTableDetails details : master.getMasterTableDetails()) {
//				Map<String, Object> childMap = new HashMap<String, Object>();
//				childMap.put("ColumnName", details.getColumnName());
//				childMap.put("ColumnType", details.getColumnType());
//				childMap.put("Constraints", details.getConstraints());
//				childObj.add(childMap);
//			}
//			map.put("TableAttributes", childObj);
//			obj.add(map);
//		}
//		
//		return obj;
//		
//	}
//
//}
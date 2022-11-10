package com.milan.mn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.milan.mn.model.MasterTable;
import com.milan.mn.model.MasterTableColumnDetails;
import com.milan.mn.repos.MasterTableRepo;

@Service
public class DynamicTableServices {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	MasterTableRepo masterTableRepo;
	
	public ResponseEntity<String> insertValueToTable(HashMap<String, Object> object, String tableName) {

		StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
		
		for (Map.Entry<String, Object> map : object.entrySet()) {
			query.append(map.getKey() + ", ");
		}
        //To replace last ',' character and place the bracket.
		query.replace(query.lastIndexOf(","), query.length(), ")");
		query.append(" values (");
		for (Map.Entry<String, Object> map : object.entrySet()) {
			query.append("'" + map.getValue() + "', ");
		}
		query.replace(query.lastIndexOf(","), query.length(), ")");

		System.out.println(query);
		EntityTransaction txn = null;
		try {
			EntityManager entityManager = emf.createEntityManager();
			txn = entityManager.getTransaction();
			txn.begin();
			Query q = entityManager.createNativeQuery(query.toString());
			int id = q.executeUpdate();
			txn.commit();
			return ResponseEntity.ok().body("Successfully Saved.");
		} catch (Throwable e) {
			if (txn != null && txn.isActive()) {
				txn.rollback();
			}
			return ResponseEntity.badRequest().body("Failed To insert To table. Exception: " + e.getMessage());
		}
	}
	
	public Object findAllValueFromTable(String tableName) {
		Optional<MasterTable> masterTable = masterTableRepo.findByTableName(tableName);
		
		int count = 0;
		HashMap<Integer, String> map = new HashMap<>();
		StringBuilder query = new StringBuilder("Select ");
		for(MasterTableColumnDetails details : masterTable.get().getMasterTableColumnDetails()) {
			map.put(count, details.getColumnName());
			query.append(details.getColumnName() + ", ");
			count++;
		}
		query.replace(query.lastIndexOf(","), query.length(), " ");
		query.append("from " + tableName);
		
		List<Object[]> resultSet = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery(query.toString());
		resultSet = q.getResultList();
		
		List<Object> obj = new ArrayList<>();
		for (Object[] d : resultSet) {	
			Map<String, Object> newMap = new HashMap<>();
			for(Map.Entry<Integer, String> m : map.entrySet()) {
				newMap.put(m.getValue(), d[m.getKey()]);
			}
			obj.add(newMap);
		}

		return obj;
	}
	
	public ResponseEntity<String> updateValueToTable(HashMap<String, Object> object, String tableName, String id) {
		
		StringBuilder query = new StringBuilder("UPDATE " + tableName + " SET ");
		
		for (Map.Entry<String, Object> map : object.entrySet()) {
			query.append(map.getKey() + " = '" + map.getValue() + "', ");
		}
		query.replace(query.lastIndexOf(","), query.length(), " ");
		query.append(" where id = " + id);
		
		EntityTransaction txn = null;
		try {
			EntityManager entityManager = emf.createEntityManager();
			txn = entityManager.getTransaction();
			txn.begin();
			Query q = entityManager.createNativeQuery(query.toString());
			q.executeUpdate();
			txn.commit();
			return ResponseEntity.ok().body("Successfully Updated.");
		} catch (Throwable e) {
			if (txn != null && txn.isActive()) {
				txn.rollback();
			}
			return ResponseEntity.badRequest().body("Failed To update. Exception: " + e.getMessage());
		}
		
	}
	
	public Object findValueFromTableGivenPK(String tableName, String id) {
		Optional<MasterTable> masterTable = masterTableRepo.findByTableName(tableName);
		
		int count = 0;
		HashMap<Integer, String> map = new HashMap<>();
		StringBuilder query = new StringBuilder("Select ");
		for(MasterTableColumnDetails details : masterTable.get().getMasterTableColumnDetails()) {
			map.put(count, details.getColumnName());
			query.append(details.getColumnName() + ", ");
			count++;
		}
		query.replace(query.lastIndexOf(","), query.length(), " ");
		query.append("from " + tableName + " where id = " + id);
		
		List<Object[]> resultSet = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		Query q = em.createNativeQuery(query.toString());
		resultSet = q.getResultList();
		
		List<Object> obj = new ArrayList<>();
		for (Object[] d : resultSet) {	
			Map<String, Object> newMap = new HashMap<>();
			for(Map.Entry<Integer, String> m : map.entrySet()) {
				newMap.put(m.getValue(), d[m.getKey()]);
			}
			obj.add(newMap);
		}
		return obj;
	}
	
	
}

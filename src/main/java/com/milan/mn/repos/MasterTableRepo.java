package com.milan.mn.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milan.mn.model.MasterTable;

@Repository
public interface MasterTableRepo extends JpaRepository<MasterTable, Integer>{
	
	public List<MasterTable> findByDynamicTableCreated(boolean bool);
	public Optional<MasterTable> findByTableName(String tableName);

}

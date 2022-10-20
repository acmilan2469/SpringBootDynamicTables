package com.milan.mn.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class MasterTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean dynamicTableCreated;
	private String tableName;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "master_table_id")
	private List<MasterTableDetails> masterTableDetails;

	

	public MasterTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MasterTable [id=" + id + ", dynamicTableCreated=" + dynamicTableCreated + ", tableName=" + tableName
				+ ", masterTableDetails=" + masterTableDetails + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MasterTable(int id, boolean dynamicTableCreated, String tableName,
			List<MasterTableDetails> masterTableDetails) {
		super();
		this.id = id;
		this.dynamicTableCreated = dynamicTableCreated;
		this.tableName = tableName;
		this.masterTableDetails = masterTableDetails;
	}

	public boolean isDynamicTableCreated() {
		return dynamicTableCreated;
	}

	public void setDynamicTableCreated(boolean dynamicTableCreated) {
		this.dynamicTableCreated = dynamicTableCreated;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<MasterTableDetails> getMasterTableDetails() {
		return masterTableDetails;
	}

	public void setMasterTableDetails(List<MasterTableDetails> masterTableDetails) {
		this.masterTableDetails = masterTableDetails;
	}

}

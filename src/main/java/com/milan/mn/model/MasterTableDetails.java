package com.milan.mn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MasterTableDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String columnName;
	private String columnType;
	private String constraints;
	private boolean primaryKey;
	
	@ManyToOne
	@JsonIgnore
	private MasterTable masterTable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getConstraints() {
		return constraints;
	}

	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public MasterTable getMasterTable() {
		return masterTable;
	}

	public void setMasterTable(MasterTable masterTable) {
		this.masterTable = masterTable;
	}

	@Override
	public String toString() {
		return "MasterTableDetails [id=" + id + ", columnName=" + columnName + ", columnType=" + columnType
				+ ", constraints=" + constraints + ", primaryKey=" + primaryKey + ", masterTable=" + masterTable + "]";
	}

}

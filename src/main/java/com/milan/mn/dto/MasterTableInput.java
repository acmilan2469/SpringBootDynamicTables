package com.milan.mn.dto;

import java.util.List;


public class MasterTableInput {

	private String tableName;
	private String nameOfMaster;
	private boolean active;
	private String applicationRole;
	private String dbType;
	
	private List<MasterTableColumnDetailsInput> masterTableColumnDetails;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getNameOfMaster() {
		return nameOfMaster;
	}

	public void setNameOfMaster(String nameOfMaster) {
		this.nameOfMaster = nameOfMaster;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getApplicationRole() {
		return applicationRole;
	}

	public void setApplicationRole(String applicationRole) {
		this.applicationRole = applicationRole;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public List<MasterTableColumnDetailsInput> getMasterTableColumnDetails() {
		return masterTableColumnDetails;
	}

	public void setMasterTableColumnDetails(List<MasterTableColumnDetailsInput> masterTableColumnDetails) {
		this.masterTableColumnDetails = masterTableColumnDetails;
	}

	@Override
	public String toString() {
		return "MasterTableInput [tableName=" + tableName + ", nameOfMaster=" + nameOfMaster + ", active=" + active
				+ ", applicationRole=" + applicationRole + ", dbType=" + dbType + ", masterTableColumnDetails="
				+ masterTableColumnDetails + "]";
	}
	

}

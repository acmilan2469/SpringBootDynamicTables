package com.milan.mn.model;

import java.time.LocalDateTime;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String tableName;
	private String nameOfMaster;
	private String tableauthMatrix;
	private boolean active;
	private String applicationRole;
	private String dbType;
	
	private LocalDateTime createdDate = LocalDateTime.now();
	private LocalDateTime updatedDate = LocalDateTime.now();
	private String createdBy;
	private String updatedBy;
		
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "master_table_id")
	private List<MasterTableColumns> masterTableColumns;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "master_table_id")
	private List<MasterTableColumnDetails> masterTableColumnDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getTableauthMatrix() {
		return tableauthMatrix;
	}

	public void setTableauthMatrix(String tableauthMatrix) {
		this.tableauthMatrix = tableauthMatrix;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<MasterTableColumns> getMasterTableColumns() {
		return masterTableColumns;
	}

	public void setMasterTableColumns(List<MasterTableColumns> masterTableColumns) {
		this.masterTableColumns = masterTableColumns;
	}

	public List<MasterTableColumnDetails> getMasterTableColumnDetails() {
		return masterTableColumnDetails;
	}

	public void setMasterTableColumnDetails(List<MasterTableColumnDetails> masterTableColumnDetails) {
		this.masterTableColumnDetails = masterTableColumnDetails;
	}

	@Override
	public String toString() {
		return "MasterTable [id=" + id + ", tableName=" + tableName + ", nameOfMaster=" + nameOfMaster
				+ ", tableauthMatrix=" + tableauthMatrix + ", active=" + active + ", applicationRole=" + applicationRole
				+ ", dbType=" + dbType + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", masterTableColumns=" + masterTableColumns
				+ ", masterTableColumnDetails=" + masterTableColumnDetails + "]";
	} 
	
}

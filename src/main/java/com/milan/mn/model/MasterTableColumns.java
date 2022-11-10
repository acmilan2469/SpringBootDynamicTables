package com.milan.mn.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MasterTableColumns {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long columnId;
	private String columnName;
		
	private LocalDateTime createdDate = LocalDateTime.now();
	private LocalDateTime updatedDate = LocalDateTime.now();
	private String createdBy;
	private String updatedBy;
		
	@ManyToOne
	@JsonIgnore
	private MasterTable masterTable;

	public long getColumnId() {
		return columnId;
	}

	public void setColumnId(long columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
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

	public MasterTable getMasterTable() {
		return masterTable;
	}

	public void setMasterTable(MasterTable masterTable) {
		this.masterTable = masterTable;
	}

	@Override
	public String toString() {
		return "MasterTableColumns [columnId=" + columnId + ", columnName=" + columnName + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", masterTable=" + masterTable + "]";
	}

}

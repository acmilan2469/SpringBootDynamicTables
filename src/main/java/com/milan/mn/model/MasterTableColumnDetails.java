package com.milan.mn.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MasterTableColumnDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long columnId;
private String columnName;
	private String columnDataType;
	private long columnMinLength;
	private long columnMaxLength;
	private String fieldType;
	private String fieldText;
	private String columnValidations;
	private String customValidations;
	private boolean mandatory = true;
	private boolean primaryKey = false;
	
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

	public String getColumnDataType() {
		return columnDataType;
	}

	public void setColumnDataType(String columnDataType) {
		this.columnDataType = columnDataType;
	}

	public long getColumnMinLength() {
		return columnMinLength;
	}

	public void setColumnMinLength(long columnMinLength) {
		this.columnMinLength = columnMinLength;
	}

	public long getColumnMaxLength() {
		return columnMaxLength;
	}

	public void setColumnMaxLength(long columnMaxLength) {
		this.columnMaxLength = columnMaxLength;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldText() {
		return fieldText;
	}

	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}

	public String getColumnValidations() {
		return columnValidations;
	}

	public void setColumnValidations(String columnValidations) {
		this.columnValidations = columnValidations;
	}

	public String getCustomValidations() {
		return customValidations;
	}

	public void setCustomValidations(String customValidations) {
		this.customValidations = customValidations;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
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
		return "MasterTableColumnDetails [columnId=" + columnId + ", columnName=" + columnName + ", columnDataType="
				+ columnDataType + ", columnMinLength=" + columnMinLength + ", columnMaxLength=" + columnMaxLength
				+ ", fieldType=" + fieldType + ", fieldText=" + fieldText + ", columnValidations=" + columnValidations
				+ ", customValidations=" + customValidations + ", mandatory=" + mandatory + ", primaryKey=" + primaryKey
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", masterTable=" + masterTable + "]";
	}

}

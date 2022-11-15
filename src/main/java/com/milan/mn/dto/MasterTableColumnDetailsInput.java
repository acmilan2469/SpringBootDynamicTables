package com.milan.mn.dto;

public class MasterTableColumnDetailsInput {

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
	@Override
	public String toString() {
		return "MasterTableColumnDetailsInput [columnName=" + columnName + ", columnDataType=" + columnDataType
				+ ", columnMinLength=" + columnMinLength + ", columnMaxLength=" + columnMaxLength + ", fieldType="
				+ fieldType + ", fieldText=" + fieldText + ", columnValidations=" + columnValidations
				+ ", customValidations=" + customValidations + ", mandatory=" + mandatory + ", primaryKey=" + primaryKey
				+ "]";
	}


}

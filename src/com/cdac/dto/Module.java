package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Module {
	
	@Id
	@GeneratedValue
	private int moduleID;
	private String moduleName;
	private String moduleType;
	@ManyToOne
	@JoinColumn(name = "teacherID")
	private Teacher teacher;
	private String startDate;
	private String endDate;
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Module(String moduleName, String moduleType, Teacher teacher, String startDate,
			String endDate) {
		super();
		this.moduleName = moduleName;
		this.moduleType = moduleType;
		this.teacher = teacher;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getModuleID() {
		return moduleID;
	}
	public void setModuleID(int moduleID) {
		this.moduleID = moduleID;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Module [moduleID=" + moduleID + ", moduleName=" + moduleName + ", moduleType=" + moduleType
				+ ", teacher=" + teacher + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + moduleID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (moduleID != other.moduleID)
			return false;
		return true;
	}

	
}

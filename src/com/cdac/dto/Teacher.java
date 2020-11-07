package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private int teacherID;
	@Column(unique = true)	
	private String teacherEmail;
	private String teacherPass;
	private String teacherName;
	@Column(name="teacherType", columnDefinition="varchar(40) default 'Module_Teacher'")
	private String teacherType;
	private String teacherPhone;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Teacher(int teacherID) {
		super();
		this.teacherID = teacherID;
	}


	public Teacher(String teacherEmail, String teacherPass, String teacherName,
			String teacherPhone) {
		super();
		this.teacherEmail = teacherEmail;
		this.teacherPass = teacherPass;
		this.teacherName = teacherName;
		this.teacherType = "Module_Teacher";
		this.teacherPhone = teacherPhone;
	}


	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public String getTeacherPass() {
		return teacherPass;
	}
	public void setTeacherPass(String teacherPass) {
		this.teacherPass = teacherPass;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherType() {
		return teacherType;
	}
	public void setTeacherType(String teacherType) {
		this.teacherType = teacherType;
	}
	
	public String getTeacherPhone() {
		return teacherPhone;
	}
	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", teacherEmail=" + teacherEmail + ", teacherPass=" + teacherPass
				+ ", teacherName=" + teacherName + ", teacherType=" + teacherType + ", teacherPhone=" + teacherPhone
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teacherEmail == null) ? 0 : teacherEmail.hashCode());
		result = prime * result + teacherID;
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
		Teacher other = (Teacher) obj;
		if (teacherEmail == null) {
			if (other.teacherEmail != null)
				return false;
		} else if (!teacherEmail.equals(other.teacherEmail))
			return false;
		if (teacherID != other.teacherID)
			return false;
		return true;
	}
	
	
	
}

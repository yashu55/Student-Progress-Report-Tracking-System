package com.cdac.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@Column(name = "studentRollNo")
	private String studentRollNo;
	@Column(unique = true)
	private String studentEmail;
	private String studentPass;
	private String studentName;
	private String studentPhone;
	
	@ManyToMany
	@JoinTable(name = "Students_Tasks",joinColumns = {@JoinColumn(name="studentRollNo")},inverseJoinColumns = {@JoinColumn(name="taskID")}) 
	private List<Task> allTasks = new ArrayList<Task>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentRollNo, String studentEmail, String studentPass, String studentName,
			String studentPhone) {
		super();
		this.studentRollNo = studentRollNo;
		this.studentEmail = studentEmail;
		this.studentPass = studentPass;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
	}

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(String studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPass() {
		return studentPass;
	}

	public void setStudentPass(String studentPass) {
		this.studentPass = studentPass;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public List<Task> getAllTasks() {
		return allTasks;
	}

	public void setAllTasks(List<Task> allTasks) {
		this.allTasks = allTasks;
	}

	@Override
	public String toString() {
		return "Student [studentRollNo=" + studentRollNo + ", studentEmail=" + studentEmail + ", studentPass="
				+ studentPass + ", studentName=" + studentName + ", studentPhone=" + studentPhone + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentEmail == null) ? 0 : studentEmail.hashCode());
		result = prime * result + ((studentRollNo == null) ? 0 : studentRollNo.hashCode());
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
		Student other = (Student) obj;
		if (studentEmail == null) {
			if (other.studentEmail != null)
				return false;
		} else if (!studentEmail.equals(other.studentEmail))
			return false;
		if (studentRollNo == null) {
			if (other.studentRollNo != null)
				return false;
		} else if (!studentRollNo.equals(other.studentRollNo))
			return false;
		return true;
	}

	
}

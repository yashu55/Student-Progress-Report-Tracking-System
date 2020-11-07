package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Student;

public interface StudentDao {
	public boolean isStudentValid(Student student);
	public void addStudent(Student student);
	public List<Student> selectAllStudent();
	public Student getStudentbyEmailID(String mailID);
	public Student getStudentbyRollNo(String rollNo);
	public void updateStudentforRollNo(String rollNo, String email, String pass, String phoneNo);

}

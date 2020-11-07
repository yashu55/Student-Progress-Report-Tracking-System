package com.cdac.service;

import java.util.List;

import com.cdac.dto.Student;

public interface StudentService {
	public boolean isStudentValid(Student student);
	public void addStudent(Student student);
	public List<Student> selectAllStudent();
	public Student getStudentbyEmailID(String mailID);
	public Student getStudentbyRollNo(String rollNo);
	public void updateStudent(Student student);
}

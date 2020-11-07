package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.StudentDao;
import com.cdac.dao.TeacherDao;
import com.cdac.dto.Student;
import com.cdac.dto.Teacher;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public boolean isStudentValid(Student student) {
		
		return studentDao.isStudentValid(student);
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
		
	}

	@Override
	public List<Student> selectAllStudent() {
		return studentDao.selectAllStudent();
	}

	@Override
	public Student getStudentbyEmailID(String mailID) {
		// TODO Auto-generated method stub
		return studentDao.getStudentbyEmailID(mailID);
	}

	@Override
	public Student getStudentbyRollNo(String rollNo) {
		// TODO Auto-generated method stub
		return studentDao.getStudentbyRollNo(rollNo);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudentforRollNo(student.getStudentRollNo(), student.getStudentEmail(), student.getStudentPass(), student.getStudentPhone());
		
	}

	
	
	

}

package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.TeacherDao;
import com.cdac.dto.Teacher;

@Service
public class TeacherServiceImple implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}

	@Override
	public List<Teacher> selectAllTeacher() {
		return teacherDao.selectAllTeacher();
	}

	@Override
	public List<Teacher> selectAllTeacherAdmin() {
		return teacherDao.selectAllTeacherAdmin();
	}
	
	@Override
	public boolean isTeacherValid(Teacher teacher) {
		return teacherDao.isTeacherValid(teacher);
	}

	@Override
	public boolean deleteTeacher(int teacherId) {
		return teacherDao.deleteTeacher(teacherId);
	}

	@Override
	public Teacher getTeacher(int teacherId) {
		// TODO Auto-generated method stub
		return  teacherDao.getTeacher(teacherId);
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.updateTeacher(teacher);
	}

	@Override
	public Teacher getTeacherByEmail(String teacherEmail) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherByEmail(teacherEmail);
	}

	

}

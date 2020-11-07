package com.cdac.service;

import java.util.List;

import com.cdac.dto.Teacher;

public interface TeacherService {
	public boolean isTeacherValid(Teacher teacher);
	public void addTeacher(Teacher teacher);
	public List<Teacher> selectAllTeacher();
	public List<Teacher> selectAllTeacherAdmin();
	public boolean deleteTeacher(int teacherId);
	public Teacher getTeacher(int teacherId);
	public boolean updateTeacher(Teacher teacher);
	public Teacher getTeacherByEmail(String teacherEmail);

}

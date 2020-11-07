package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Teacher;

public interface TeacherDao {
	public boolean isTeacherValid(Teacher teacher);
	public void addTeacher(Teacher teacher);
	public List<Teacher> selectAllTeacher();
	public List<Teacher> selectAllTeacherAdmin();
	public boolean deleteTeacher(int teacherId);
	public Teacher getTeacher(int teacherId);
	public boolean updateTeacher(Teacher teacher);
	public Teacher getTeacherByEmail(String teacherEmail);
}

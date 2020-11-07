package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.StudentsTasksDao;
import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Task;

@Service
public class StudentsTasksServiceImple implements StudentsTasksService {

	
	@Autowired
	private StudentsTasksDao studentsTasksDao;
	
	@Override
	public List<Students_Tasks> getStudentTaskByStudent(Student student) {
		return studentsTasksDao.getStudentTaskByStudent(student);
	}

	@Override
	public Students_Tasks getStudentTaskByStudentAndTask(Student student, Task task) {
		return studentsTasksDao.getStudentTaskByStudentAndTask(student, task);
	}

	@Override
	public Students_Tasks getStudentTasks(int Students_Tasks_ID) {
		return studentsTasksDao.getStudentTasks(Students_Tasks_ID) ;
	}

	@Override
	public boolean changeTaskStatus(int taskStatus, int Students_Tasks_ID) {
		
		return studentsTasksDao.changeTaskStatus(taskStatus, Students_Tasks_ID);
	}

	@Override
	public boolean changeTaskMarks(int marks, int Students_Tasks_ID) {
		// TODO Auto-generated method stub
		return studentsTasksDao.changeTaskMarks(marks, Students_Tasks_ID);
	}

}

package com.cdac.service;

import java.util.List;

import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Task;

public interface StudentsTasksService {
	public List<Students_Tasks> getStudentTaskByStudent(Student student);
	public Students_Tasks getStudentTaskByStudentAndTask(Student student, Task task);
	public Students_Tasks getStudentTasks(int Students_Tasks_ID);
	public boolean changeTaskStatus(int taskStatus, int Students_Tasks_ID);
	public boolean changeTaskMarks(int marks, int Students_Tasks_ID);


}

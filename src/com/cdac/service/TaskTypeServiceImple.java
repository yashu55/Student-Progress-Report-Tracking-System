package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.TaskTypeDao;
import com.cdac.dto.TaskType;
import com.cdac.dto.Teacher;



@Service
public class TaskTypeServiceImple implements TaskTypeService {

	@Autowired
	private TaskTypeDao taskTypeDao;
	
	@Override
	public List<TaskType> selectAllTaskType() {
		return taskTypeDao.selectAllTaskType();
	}

	@Override
	public TaskType getTaskType(int taskTypeID) {
		return taskTypeDao.getTaskType(taskTypeID);
	}

	@Override
	public void addTaskType(TaskType taskType) {
		taskTypeDao.addTaskType(taskType);
	}

	

	
	
	
	
	
}

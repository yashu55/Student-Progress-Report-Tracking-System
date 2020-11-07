package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.TaskDao;
import com.cdac.dto.Module;
import com.cdac.dto.Task;

@Service
public class TaskServiceImple implements TaskService {

	@Autowired
	private TaskDao taskDao;
	
	@Override
	public void addTask(Task task) {
		taskDao.addTask(task);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Task> selectAllTasks() {
		// TODO Auto-generated method stub
		return taskDao.selectAllTasks();
	}

	@Override
	public List<Task> getTasksByModuleList(List<Module> moduleList) {
		// TODO Auto-generated method stub
		return taskDao.getTasksByModuleList(moduleList);
	}

}

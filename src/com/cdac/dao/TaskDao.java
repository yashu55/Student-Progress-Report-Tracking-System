package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Module;
import com.cdac.dto.Task;

public interface TaskDao {

	public void addTask(Task task);
	public List<Task> selectAllTasks();
	public List<Task> getTasksByModuleList(List<Module> moduleList);
}

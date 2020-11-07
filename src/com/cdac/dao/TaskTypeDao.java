package com.cdac.dao;

import java.util.List;

import com.cdac.dto.TaskType;

public interface TaskTypeDao {

	public List<TaskType> selectAllTaskType();
	public TaskType getTaskType(int taskTypeID);
	public void addTaskType(TaskType taskType);

}

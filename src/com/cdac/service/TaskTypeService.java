package com.cdac.service;

import java.util.List;

import com.cdac.dto.Module;
import com.cdac.dto.Task;
import com.cdac.dto.TaskType;
import com.cdac.dto.Teacher;

public interface TaskTypeService {

	public List<TaskType> selectAllTaskType();
	public TaskType getTaskType(int taskTypeID);
	public void addTaskType(TaskType taskType);


}

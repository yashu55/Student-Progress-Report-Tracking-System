package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TaskType {

	@Id
	@GeneratedValue
	private int taskTypeID;
	private String taskTypeName;
	private int taskMaxMarks;
	public TaskType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskType(String taskName, int taskMaxMarks) {
		super();
		this.taskTypeName = taskName;
		this.taskMaxMarks = taskMaxMarks;
	}
	public int getTaskTypeID() {
		return taskTypeID;
	}
	public void setTaskTypeID(int taskTypeID) {
		this.taskTypeID = taskTypeID;
	}
	public String getTaskTypeName() {
		return taskTypeName;
	}
	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}
	public int getTaskMaxMarks() {
		return taskMaxMarks;
	}
	public void setTaskMaxMarks(int taskMaxMarks) {
		this.taskMaxMarks = taskMaxMarks;
	}
	@Override
	public String toString() {
		return "TaskType [taskTypeID=" + taskTypeID + ", taskName=" + taskTypeName + ", taskMaxMarks=" + taskMaxMarks + "]";
	}
	
	
}

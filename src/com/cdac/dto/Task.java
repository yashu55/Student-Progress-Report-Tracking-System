package com.cdac.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue
	@Column(name= "taskID")
	private int taskID;
	
	@ManyToOne
	@JoinColumn(name = "taskTypeID")
	private TaskType taskType;
	private String taskName;
	private String taskInstruction;
	private String taskLink;
	private String dueDate;
	private String dueTime;
	
	

	
	
	@ManyToOne
	@JoinColumn(name = "moduleID")
	private Module module;
	
	@ManyToMany(mappedBy = "allTasks")
	private List<Student> allStudents = new ArrayList<Student>();

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(TaskType taskType, String taskName, String taskInstruction, String taskLink, String dueDate,
			String dueTime, Module module) {
		super();
		this.taskType = taskType;
		this.taskName = taskName;
		this.taskInstruction = taskInstruction;
		this.taskLink = taskLink;
		this.dueDate = dueDate;
		this.dueTime = dueTime;
		this.module = module;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskInstruction() {
		return taskInstruction;
	}

	public void setTaskInstruction(String taskInstruction) {
		this.taskInstruction = taskInstruction;
	}

	public String getTaskLink() {
		return taskLink;
	}

	public void setTaskLink(String taskLink) {
		this.taskLink = taskLink;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueTime() {
		return dueTime;
	}

	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Student> getAllStudents() {
		return allStudents;
	}

	public void setAllStudents(List<Student> allStudents) {
		this.allStudents = allStudents;
	}

	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", taskType=" + taskType + ", taskName=" + taskName + ", taskInstruction="
				+ taskInstruction + ", taskLink=" + taskLink + ", dueDate=" + dueDate + ", dueTime=" + dueTime
				+ ", module=" + module + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + taskID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (taskID != other.taskID)
			return false;
		return true;
	}

	
	
	
}

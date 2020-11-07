package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Students_Tasks {
	
	@Id
	@GeneratedValue
	private int Students_Tasks_ID;
	
	@ManyToOne
	@JoinColumn(name = "studentRollNo")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "taskID")
	private Task task;
	
	@Column(name="marks", columnDefinition="Decimal(10,2) default '0.00'")
	private double marks;
	@Column(name="taskStatus", columnDefinition="Int(10) default '0'")
	private int taskStatus;
	public Students_Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Students_Tasks(Student student, Task task, double marks, int taskStatus) {
		super();
		this.student = student;
		this.task = task;
		this.marks = 0.0;
		this.taskStatus = 0;
	}
	public int getStudents_Tasks_ID() {
		return Students_Tasks_ID;
	}
	public void setStudents_Tasks_ID(int students_Tasks_ID) {
		Students_Tasks_ID = students_Tasks_ID;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public int getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}
	@Override
	public String toString() {
		return "Students_Tasks [Students_Tasks_ID=" + Students_Tasks_ID + ", student=" + student + ", task=" + task
				+ ", marks=" + marks + ", taskStatus=" + taskStatus + "]";
	}	
}

package com.cdac.cntr;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Teacher;
import com.cdac.service.StudentService;
import com.cdac.service.StudentsTasksService;
import com.cdac.service.TaskService;

@Controller
public class StudentCntr {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentsTasksService studentsTasksService; 

	@RequestMapping(value = "/StudentLogin")
	public String prepareStudentLoginForm() {
		return "StudentLogin";
	}
	
	
	
	
	
	@RequestMapping(value = "/StudentLoginSubmit" , method = RequestMethod.POST)
	public String submitStudentLoginForm(ModelMap map, Student student, HttpSession session, HttpServletResponse response) throws IOException {
		boolean isStudentValid = studentService.isStudentValid(student);
		if(isStudentValid) {
			session.setAttribute("student_login", student.getStudentEmail());
			session.setAttribute("logged_student_Rollno", studentService.getStudentbyEmailID(student.getStudentEmail()).getStudentRollNo());
			return "StudentHome";
		}else {
			response.sendRedirect("StudentLogin?errorMsg=true");
			return "StudentLogin";
		}
	}
	
	
	
	@RequestMapping(value = "/StudentHome")
	public String StudentHome(HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionStudent(hs, r);
		return "StudentHome";
	}
	
	@RequestMapping(value = "/LoggedStudentUpdateSubmit" , method = RequestMethod.POST)
	public void LoggedStudentUpdateSubmit(ModelMap map, Student student, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionStudent(hs, r);
		studentService.updateStudent(student);
		r.sendRedirect("Logout");
	}
	
	
	@RequestMapping(value = "/LoggedStudentInfo")
	public String LoggedStudentInfo(Student student, ModelMap map, HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionStudent(hs, r);
		System.out.println();
		student = studentService.getStudentbyRollNo((String) hs.getAttribute("logged_student_Rollno"));
		map.put("Logged_Student_Details", student);
		return "LoggedStudentInfo";
	}
	
	@RequestMapping(value = "/LoggedStudentTaskList")
	public String LoggedStudentTaskList(Student student, ModelMap map, HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionStudent(hs, r);
		student = studentService.getStudentbyRollNo((String) hs.getAttribute("logged_student_Rollno"));
		map.put("All_Task_list",studentsTasksService.getStudentTaskByStudent(student));
		map.put("Logged_Student_Details", student);
		System.out.println(studentsTasksService.getStudentTaskByStudent(student));
		return "LoggedStudentTaskList";
	}

	
	@RequestMapping(value = "/LoggedStudentShowTaskDetails")
	public String LoggedStudentShowTaskDetails(Students_Tasks studentsTasks ,Student student, ModelMap map, HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionStudent(hs, r);
		System.out.println(studentsTasks.getStudents_Tasks_ID());		
		map.put("LoggedStudentShowTaskDetails", studentsTasksService.getStudentTasks(studentsTasks.getStudents_Tasks_ID()));
		return "LoggedStudentShowTaskDetails";
	}
	
	@RequestMapping(value = "/LoggedStudentShowTaskDetailsSubmit")
	public String LoggedStudentShowTaskDetailsSubmit(Students_Tasks studentsTasks ,Student student, ModelMap map, HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionStudent(hs, r);
//		System.out.println("--------------");
//		System.out.println(studentsTasks.getStudents_Tasks_ID());
//		System.out.println(studentsTasks.getTaskStatus());
//		System.out.println("--------------");

		if(studentsTasks.getTaskStatus() == 0)
			studentsTasksService.changeTaskStatus(1,studentsTasks.getStudents_Tasks_ID());
		
		
		//studentsTasksService.changeStatus(studentsTasks.getStudents_Tasks_ID());
		studentsTasks = studentsTasksService.getStudentTasks(studentsTasks.getStudents_Tasks_ID());
		r.sendRedirect("LoggedStudentShowTaskDetails?taskID=" + studentsTasks.getTask().getTaskID() + "&Students_Tasks_ID=" + studentsTasks.getStudents_Tasks_ID());
		return null;
	}
	
	
	
}

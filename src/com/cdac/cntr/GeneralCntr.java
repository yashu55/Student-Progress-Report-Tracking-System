package com.cdac.cntr;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralCntr {
	
	@RequestMapping(value="/Features")
	public String feature() {
		return "Features";
	}
	
	@RequestMapping(value="/About")
	public String About() {
		return "About";
	}

	@RequestMapping(value = "/Logout")
	public String logout(HttpSession session, HttpServletResponse response) throws IOException {
		
		session.invalidate();
		
		response.sendRedirect("./");
		return null;
	}
	
	public static void checkSessionTeacher(HttpSession hs,HttpServletResponse r) throws IOException {
		String s = (String) hs.getAttribute("teacher_login");
		String teacherType = (String) hs.getAttribute("teacher_type");

		
		if(s == null || !teacherType.equals("Admin")) {
			r.sendRedirect("./");	
		}
	}
	
	public static void checkSessionTeacherNonAdmin(HttpSession hs,HttpServletResponse r) throws IOException {
		String s = (String) hs.getAttribute("teacher_login");
		String teacherType = (String) hs.getAttribute("teacher_type");

		
		if(s == null || !teacherType.equals("Module_Teacher")) {
			r.sendRedirect("./");	
		}
	}
	
	public static void checkSessionStudent(HttpSession hs,HttpServletResponse r) throws IOException {
		String s1 = (String) hs.getAttribute("student_login");
		if(s1 == null) {
			r.sendRedirect("./");	
		}
	}
	
	
	
	
	@RequestMapping(value = "/*")
	public String error() {
		
		return "error";	
	}
	
}

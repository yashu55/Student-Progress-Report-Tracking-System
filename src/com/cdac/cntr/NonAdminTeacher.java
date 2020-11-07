package com.cdac.cntr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Module;
import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Task;
import com.cdac.dto.TaskType;
import com.cdac.dto.Teacher;
import com.cdac.service.ModuleService;
import com.cdac.service.StudentService;
import com.cdac.service.StudentsTasksService;
import com.cdac.service.TaskService;
import com.cdac.service.TaskTypeService;
import com.cdac.service.TeacherService;

@Controller
public class NonAdminTeacher {

	@Autowired
	TeacherService teacherService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskTypeService taskTypeService;

	@Autowired
	private StudentsTasksService studentsTasksService;

	@RequestMapping(value = "/TeacherHomeNonAdmin")
	public String TeacherHome(HttpSession hs, HttpServletResponse r, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		map.put("Student_List", studentService.selectAllStudent());
		return "TeacherHomeNonAdmin";
	}

	@RequestMapping(value = "/LoggedTeacherModuleInfo")
	public String LoggedTeacherModuleInfo(Teacher teacher, HttpSession hs, HttpServletResponse r, ModelMap map)
			throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		String s = (String) hs.getAttribute("teacher_login");
		teacher = teacherService.getTeacherByEmail(s);
		List<Module> moduleList = moduleService.selectModuleForTeacher(teacher);
		map.put("module_list", moduleList);
		return "LoggedTeacherModuleInfo";
	}

	@RequestMapping(value = "/LoggedTeacherTeacherInfo")
	public String LoggedTeacherTeacherInfo(Teacher teacher, HttpSession hs, HttpServletResponse r, ModelMap map)
			throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		String s = (String) hs.getAttribute("teacher_login");
		teacher = teacherService.getTeacherByEmail(s);
		map.put("teacher_details", teacher);
		return "LoggedTeacherTeacherInfo";
	}

	@RequestMapping(value = "/LoggedTeacherTeacherInfoSubmit", method = RequestMethod.POST)
	public void LoggedTeacherTeacherInfoSubmit(ModelMap map, Teacher teacher, HttpSession hs, HttpServletResponse r)
			throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		//System.out.println(teacher);
		Teacher t = teacherService.getTeacher(teacher.getTeacherID());
		teacher.setTeacherType(t.getTeacherType());
		boolean b = teacherService.updateTeacher(teacher);
		r.sendRedirect("Logout");
	}

	@RequestMapping(value = "/LoggedTeacherAddTask")
	public String LoggedTeacherAddTask(Teacher teacher, HttpSession hs, HttpServletResponse r, ModelMap map)
			throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		String s = (String) hs.getAttribute("teacher_login");
		teacher = teacherService.getTeacherByEmail(s);
		List<Module> moduleList = moduleService.selectModuleForTeacher(teacher);
		List<TaskType> taskTypeList = taskTypeService.selectAllTaskType();
		map.put("Module_List", moduleList);
		map.put("TaskType_List", taskTypeList);
		return "LoggedTeacherAddTask";
	}

	@RequestMapping(value = "/LoggedTeacherAddTaskSubmit", method = RequestMethod.POST)
	public String LoggedTeacherAddTaskSubmit(@RequestParam String moduleID, @RequestParam String taskTypeID, Task task,
			ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		//System.out.println(moduleID);
		task.setModule(moduleService.getModule(Integer.parseInt(moduleID)));
		//System.out.println(taskTypeID);
		//System.out.println(task);
		//System.out.println(task.getModule());
		//System.out.println(taskTypeService.getTaskType(Integer.parseInt(taskTypeID)));

		task.setTaskType(taskTypeService.getTaskType(Integer.parseInt(taskTypeID)));

		//System.out.println(task);
		taskService.addTask(task);
		r.sendRedirect("TeacherHomeNonAdmin");
		return null;
	}

	@RequestMapping(value = "/LoggedTeacherEvaluateStudent", method = RequestMethod.GET)
	public String LoggedTeacherEvaluateStudent( Student student, Teacher teacher,
			@RequestParam String studentRollNo, ModelMap map, HttpSession hs, HttpServletResponse r)
			throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		String teacherEmail = (String) hs.getAttribute("teacher_login");
		teacher = teacherService.getTeacherByEmail(teacherEmail);
		List<Module> moduleList = moduleService.selectModuleForTeacher(teacher);
		List<Task> taskList = taskService.getTasksByModuleList(moduleList);
		student = studentService.getStudentbyRollNo(studentRollNo);
		List<Students_Tasks> stuAll = new ArrayList<Students_Tasks>();

		for (Task task : taskList) {
			stuAll.add(studentsTasksService.getStudentTaskByStudentAndTask(student, task  ));
			
		}
		map.put("stuTasksAll", stuAll);
		map.put("student", student);
	
		return "LoggedTeacherEvaluateStudent";
	}
	
	
		
	
	@RequestMapping(value = "/LoggedTeacherEvaluateStudentSubmit")
	public String LoggedTeacherEvaluateScoreSubmitMarks(@RequestParam int Students_Tasks_ID,@RequestParam int marks,@RequestParam String studentRollNo, HttpSession hs, HttpServletResponse r, ModelMap map)
			throws IOException {
		
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		System.out.println(marks);
		System.out.println(Students_Tasks_ID);
		
		studentsTasksService.changeTaskMarks(marks, Students_Tasks_ID);
		int maxMarks = studentsTasksService.getStudentTasks(Students_Tasks_ID).getTask().getTaskType().getTaskMaxMarks();
		
		if(((double)marks)/((double)maxMarks) < 0.40) 
			studentsTasksService.changeTaskStatus(3, Students_Tasks_ID);
		else if(((double)marks)/((double)maxMarks) >= 0.40)
			studentsTasksService.changeTaskStatus(2, Students_Tasks_ID);

		r.sendRedirect("LoggedTeacherEvaluateStudent?studentRollNo=" + studentRollNo);
		return null;
	}
	
	
	@RequestMapping(value = "/LoggedTeacherShowTaskDetails")
	public String LoggedTeacherShowTaskDetails(Students_Tasks studentsTasks ,Student student, ModelMap map, HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionTeacherNonAdmin(hs, r);
		System.out.println(studentsTasks.getStudents_Tasks_ID());		
		map.put("LoggedTeacherShowTaskDetails", studentsTasksService.getStudentTasks(studentsTasks.getStudents_Tasks_ID()));
		return "LoggedTeacherShowTaskDetails";
	}
	
	



}

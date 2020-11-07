package com.cdac.cntr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
public class TeacherCntr {

	@Autowired
	TeacherService teacherService;

	@Autowired
	ModuleService moduleService;

	@Autowired
	StudentService studentService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskTypeService taskTypeService;

	@Autowired
	private StudentsTasksService studentsTasksService;

	@RequestMapping(value = "/TeacherLogin")
	public String prepareTeacherLoginForm() {
		return "TeacherLogin";
	}

	@RequestMapping(value = "/TeacherLoginSubmit", method = RequestMethod.POST)
	public String submitTeacherLoginForm(ModelMap map, Teacher teacher, HttpSession session,
			HttpServletResponse response) throws IOException {
		boolean isTeacherValid = teacherService.isTeacherValid(teacher);

		if (isTeacherValid) {
			String teacherType = teacherService.getTeacherByEmail(teacher.getTeacherEmail()).getTeacherType();
			session.setAttribute("teacher_login", teacher.getTeacherEmail());
			session.setAttribute("teacher_type",
					teacherService.getTeacherByEmail(teacher.getTeacherEmail()).getTeacherType());

			if (teacherType.equals("Admin"))
				return "TeacherHome";
			else if (teacherType.equals("Module_Teacher")) {
				response.sendRedirect("TeacherHomeNonAdmin");
				return null;
			} else
				return "Error";
		}

		else {
			response.sendRedirect("TeacherLogin?errorMsg=true");
			return null;
		}
	}

	@RequestMapping(value = "/TeacherHome")
	public String TeacherHome(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "TeacherHome";
	}

	@RequestMapping(value = "/TeacherMenu")
	public String TeacherMenu(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "TeacherMenu";
	}

	@RequestMapping(value = "/ProgressReport")
	public String ProgressReport(HttpSession hs, HttpServletResponse r, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		map.put("Student_List", studentService.selectAllStudent());
		return "ProgressReport";
	}

	@RequestMapping(value = "/ProgressReportSubmit", method = RequestMethod.GET)
	public String ProgressReportSubmit(Student student, Teacher teacher, @RequestParam String studentRollNo,
			ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		String teacherEmail = (String) hs.getAttribute("teacher_login");
		teacher = teacherService.getTeacherByEmail(teacherEmail);
		List<Module> moduleList = moduleService.selectModuleForTeacher(teacher);
		List<Task> taskList = taskService.getTasksByModuleList(moduleList);
		student = studentService.getStudentbyRollNo(studentRollNo);
		List<Students_Tasks> stuAll = new ArrayList<Students_Tasks>();

		for (Task task : taskList) {
			stuAll.add(studentsTasksService.getStudentTaskByStudentAndTask(student, task));
		}
		map.put("stuTasksAll", stuAll);
		map.put("student", student);
		return "ProgressReportSubmit";
	}

	@RequestMapping(value = "/ProgressReportSubmitScore")
	public String ProgressReportSubmitScore(@RequestParam int Students_Tasks_ID, @RequestParam int marks,
			@RequestParam String studentRollNo, HttpSession hs, HttpServletResponse r, ModelMap map)
			throws IOException {

		GeneralCntr.checkSessionTeacher(hs, r);
		System.out.println(marks);
		System.out.println(Students_Tasks_ID);

		studentsTasksService.changeTaskMarks(marks, Students_Tasks_ID);
		int maxMarks = studentsTasksService.getStudentTasks(Students_Tasks_ID).getTask().getTaskType()
				.getTaskMaxMarks();

		if (((double) marks) / ((double) maxMarks) < 0.40)
			studentsTasksService.changeTaskStatus(3, Students_Tasks_ID);
		else if (((double) marks) / ((double) maxMarks) >= 0.40)
			studentsTasksService.changeTaskStatus(2, Students_Tasks_ID);
		r.sendRedirect("ProgressReportSubmit?studentRollNo=" + studentRollNo);
		return null;
	}

	
		
	
	@RequestMapping(value = "/TeacherShowTaskDetails")
	public String TeacherShowTaskDetails(Students_Tasks studentsTasks ,Student student, ModelMap map, HttpServletResponse r, HttpSession hs) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		System.out.println(studentsTasks.getStudents_Tasks_ID());		
		map.put("TeacherShowTaskDetails", studentsTasksService.getStudentTasks(studentsTasks.getStudents_Tasks_ID()));
		return "TeacherShowTaskDetails";
	}
	
	@RequestMapping(value = "/SettingMenu")
	public String SettingMenu(Teacher teacher, ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		String s = (String) hs.getAttribute("teacher_login");
		teacher = teacherService.getTeacherByEmail(s);
		map.put("teacher_details", teacher);
		return "SettingMenu";
	}

	@RequestMapping(value = "/SettingMenuSubmit", method = RequestMethod.POST)
	public void LoggedTeacherTeacherInfoSubmit(ModelMap map, Teacher teacher, HttpSession hs, HttpServletResponse r)
			throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		teacher.setTeacherType("Admin");
		teacherService.updateTeacher(teacher);
		r.sendRedirect("Logout");
	}

	@RequestMapping(value = "/AddTeacher")
	public String AddTeacher(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "AddTeacher";
	}

	@RequestMapping(value = "/AddTeacherSubmit", method = RequestMethod.POST)
	public String AddTeacherSubmit(Teacher teacher, ModelMap map, HttpSession hs, HttpServletResponse r)
			throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		teacherService.addTeacher(teacher);
		r.sendRedirect("TeacherMenu");
		return null;
	}

	@RequestMapping(value = "/ShowAllTeachers")
	public String ShowAllTeachers(ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		List<Teacher> li = teacherService.selectAllTeacher();
		map.put("All_Teacher_List", li);
		return "ShowAllTeachers";
	}

	@RequestMapping(value = "/DeleteTeacher", method = RequestMethod.GET)
	public String DeleteTeacher(HttpSession hs, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		GeneralCntr.checkSessionTeacher(hs, response);
		request.getParameter("TeacherId");
		try {
			int teacherId = Integer.parseInt(request.getParameter("TeacherId"));
			moduleService.updateModuleForDelete(teacherId);
			boolean isDeleteSuccessful = teacherService.deleteTeacher(teacherId);
		} catch (NumberFormatException e) {
			System.out.println("e");
		}
		response.sendRedirect("ShowAllTeachers");
		return null;
	}

	@RequestMapping(value = "/UpdateTeacher", method = RequestMethod.GET)
	public String UpdateTeacher(HttpSession hs, HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws IOException {
		GeneralCntr.checkSessionTeacher(hs, response);
		request.getParameter("TeacherId");
		try {
			int teacherId = Integer.parseInt(request.getParameter("TeacherId"));
			Teacher teacher = teacherService.getTeacher(teacherId);
			map.put("Update_Teacher", teacher);
		} catch (NumberFormatException e) {
			System.out.println("e");
		}
		return "UpdateTeacher";
	}

	@RequestMapping(value = "/UpdateTeacherSubmit", method = RequestMethod.POST)
	public String UpdateTeacherSubmit(Teacher teacher, HttpSession hs, HttpServletRequest request,
			HttpServletResponse response, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, response);
		System.out.println(teacher);
		Teacher t = teacherService.getTeacher(teacher.getTeacherID());
		teacher.setTeacherPass(t.getTeacherPass());
		teacher.setTeacherType(t.getTeacherType());
		boolean b = teacherService.updateTeacher(teacher);
		response.sendRedirect("ShowAllTeachers");
		return null;
	}

	////////////////////////////
	@RequestMapping(value = "/ModuleMenu")
	public String ModuleMenu(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "ModuleMenu";
	}

	@RequestMapping(value = "/AddModule")
	public String AddModule(Teacher teacher, HttpSession hs, HttpServletResponse r, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		map.put("All_Teachers", teacherService.selectAllTeacherAdmin());
		return "AddModule";
	}

	@RequestMapping(value = "/AddModuleSubmit", method = RequestMethod.POST)
	public String AddModuleSubmit(@RequestParam String teacherID, Module module, HttpSession hs, HttpServletResponse r,
			ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		int TeacherID = Integer.parseInt(teacherID);
		Teacher t = teacherService.getTeacher(TeacherID);
		module.setTeacher(t);
		System.out.println(t);
		System.out.println(module);
		moduleService.addModule(module);
		r.sendRedirect("ModuleMenu");
		return null;
	}

	@RequestMapping(value = "/ShowAllModules")
	public String ShowAllModules(ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		List<Module> li = moduleService.selectAllModule();
		map.put("All_Module_List", li);
		return "ShowAllModules";
	}

	@RequestMapping(value = "/UpdateModule", method = RequestMethod.GET)
	public String UpdateModule(HttpSession hs, HttpServletRequest request, HttpServletResponse response, ModelMap map)
			throws IOException {
		GeneralCntr.checkSessionTeacher(hs, response);
		request.getParameter("ModuleID");
		try {
			int ModuleID = Integer.parseInt(request.getParameter("ModuleID"));
			Module module = moduleService.getModule(ModuleID);
			map.put("Update_Module", module);
			map.put("All_Teachers", teacherService.selectAllTeacherAdmin());
		} catch (NumberFormatException e) {
			System.out.println("e");
		}
		return "UpdateModule";
	}

	@RequestMapping(value = "/UpdateModuleSubmit", method = RequestMethod.POST)
	public String UpdateTeacherSubmit(@RequestParam String teacherID, Module module, HttpSession hs,
			HttpServletRequest request, HttpServletResponse response, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, response);
		module.setTeacher(teacherService.getTeacher(Integer.parseInt(teacherID)));
		moduleService.updateModule(module);
		response.sendRedirect("ShowAllModules");
		return null;
	}
	/////////////////////////////////

	@RequestMapping(value = "/StudentMenu")
	public String StudentMenu(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "StudentMenu";
	}

	@RequestMapping(value = "/AddStudent")
	public String AddStudent(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "AddStudent";
	}

	@RequestMapping(value = "/AddStudentSubmit", method = RequestMethod.POST)
	public String AddStudentSubmit(Student student, ModelMap map, HttpSession hs, HttpServletResponse r)
			throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		studentService.addStudent(student);
		r.sendRedirect("StudentMenu");
		return null;
	}

	@RequestMapping(value = "/ShowAllStudents")
	public String ShowAllStudents(ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		List<Student> li = studentService.selectAllStudent();
		map.put("All_Student_List", li);
		return "ShowAllStudents";
	}

	////////////////////////////////////////////

	@RequestMapping(value = "/TaskMenu")
	public String TaskMenu(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "TaskMenu";
	}

	@RequestMapping(value = "/AddTask")
	public String AddTask(HttpSession hs, HttpServletResponse r, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		List<Module> moduleList = moduleService.selectAllModule();
		List<TaskType> taskTypeList = taskTypeService.selectAllTaskType();
		map.put("Module_List", moduleList);
		map.put("TaskType_List", taskTypeList);
		return "AddTask";
	}

	@RequestMapping(value = "/AddTaskSubmit", method = RequestMethod.POST)
	public String AddTaskSubmit(@RequestParam String moduleID, @RequestParam String taskTypeID, Task task, ModelMap map,
			HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		System.out.println(moduleID);
		task.setModule(moduleService.getModule(Integer.parseInt(moduleID)));
		System.out.println(taskTypeID);
		System.out.println(task);
		System.out.println(task.getModule());
		System.out.println(taskTypeService.getTaskType(Integer.parseInt(taskTypeID)));

		task.setTaskType(taskTypeService.getTaskType(Integer.parseInt(taskTypeID)));

		System.out.println(task);
		taskService.addTask(task);
		r.sendRedirect("TaskMenu");
		return null;
	}

	@RequestMapping(value = "/ShowAllTasks")
	public String ShowAllTasks(ModelMap map, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		List<Task> li = taskService.selectAllTasks();
		map.put("All_Task_List", li);
		return "ShowAllTasks";
	}

	//////////////////////////////////////////////

	@RequestMapping(value = "/TaskTypeMenu")
	public String TaskTypeMenu(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "TaskTypeMenu";
	}

	@RequestMapping(value = "/AddTaskType")
	public String AddTaskType(HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		return "AddTaskType";
	}

	@RequestMapping(value = "/AddTaskTypeSubmit", method = RequestMethod.POST)
	public String AddTaskTypeSubmit(TaskType taskType, HttpSession hs, HttpServletResponse r) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		// System.out.println(taskType);
		taskTypeService.addTaskType(taskType);
		r.sendRedirect("TaskTypeMenu");
		return null;
	}

	@RequestMapping(value = "/ShowAllTaskTypes")
	public String ShowAllTaskTypes(HttpSession hs, HttpServletResponse r, ModelMap map) throws IOException {
		GeneralCntr.checkSessionTeacher(hs, r);
		List<TaskType> li = taskTypeService.selectAllTaskType();
		map.put("All_TaskType_List", li);
		return "ShowAllTaskTypes";
	}

}

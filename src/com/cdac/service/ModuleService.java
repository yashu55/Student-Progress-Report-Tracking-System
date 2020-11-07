package com.cdac.service;

import java.util.List;

import com.cdac.dto.Module;
import com.cdac.dto.Teacher;

public interface ModuleService {
	public void addModule(Module module);
	public List<Module> selectAllModule();
	public List<Module> selectModuleForTeacher(Teacher teacher);
	public boolean deleteModule(int moduleID);
	public Module getModule(int moduleID);
	public boolean updateModule(Module module);
	public boolean updateModuleForDelete(int teacherID);

}

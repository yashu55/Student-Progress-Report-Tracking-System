package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ModuleDao;
import com.cdac.dto.Module;
import com.cdac.dto.Teacher;

@Service
public class ModuleServiceImple implements ModuleService{

	@Autowired
	ModuleDao moduleDao;
	
	
	@Override
	public void addModule(Module module) {
		moduleDao.addModule(module);
	}

	@Override
	public List<Module> selectAllModule() {
		return moduleDao.selectAllModule();
	}

	@Override
	public List<Module> selectModuleForTeacher(Teacher teacher) {
		return moduleDao.selectModuleForTeacher(teacher);
	}

	@Override
	public boolean deleteModule(int moduleID) {
		return moduleDao.deleteModule(moduleID);
	}

	@Override
	public Module getModule(int moduleID) {
		return moduleDao.getModule(moduleID);
	}

	@Override
	public boolean updateModule(Module module) {
		return moduleDao.updateModule(module);
	}

	@Override
	public boolean updateModuleForDelete(int teacherID) {
		
		return moduleDao.updateModuleForDelete(teacherID);
	}

}

package com.cdac.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Module;
import com.cdac.dto.Teacher;
import com.cdac.service.TeacherService;


@Repository
public class ModuleDaoImple implements ModuleDao {

	@Autowired
	HibernateTemplate ht;
	
	@Autowired
	TeacherService ts;
	
	@Override
	public void addModule(Module module) {
		ht.execute(new HibernateCallback<Void>() {	
			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(module);
				tr.commit();
				session.flush();
				session.close();
				return null;
			} 
		});
	}

	@Override
	public List<Module> selectAllModule() {
		return ht.execute(new HibernateCallback<List<Module>>() {

			@Override
			public List<Module> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Module");
				List <Module> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public List<Module> selectModuleForTeacher(Teacher teacher) {
		return ht.execute(new HibernateCallback<List<Module>>() {
			@Override
			public List<Module> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Criteria q = session.createCriteria(Module.class);
				q.add(Restrictions.eq("teacher", teacher));
				List <Module> li = q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public boolean deleteModule(int moduleID) {
		return ht.execute(new HibernateCallback<Boolean>() {	
			@Override
			 public Boolean doInHibernate(Session session) throws HibernateException {

				Transaction tr = session.beginTransaction();
				
				Module module = (Module) session.get(Module.class, moduleID); //new Teacher(teacherId);
				if(module == null) {
					return false;
				}
				session.delete(module);
				tr.commit();
				session.flush();
				session.close();
				return true;
			} 
		});
	}

	@Override
	public Module getModule(int moduleID) {
		return ht.execute(new HibernateCallback<Module>() {

			@Override
			public Module doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Module where moduleID = ?");
				q.setInteger(0,moduleID);
				List <Module> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				//System.out.println(li);
				return li.get(0);
			}
		});
	}

	@Override
	public boolean updateModule(Module module) {
		return ht.execute(new HibernateCallback<Boolean>() {	
			@Override
			 public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.update(module);
				tr.commit();
				session.flush();
				session.close();
				return true;
			} 
		});
	}

	@Override
	public boolean updateModuleForDelete(int teacherID) {
		return ht.execute(new HibernateCallback<Boolean>() {	
			@Override
			 public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Teacher teacher = ts.getTeacher(teacherID);
				Teacher admin = ts.getTeacher(1);
				Criteria q = session.createCriteria(Module.class);
				q.add(Restrictions.eq("teacher", teacher));
				List <Module> li = q.list();
				
				for(Module m : li) {
					m.setTeacher(admin);
				}
				
				tr.commit();
				session.flush();
				session.close();
				return true;
			} 
		});
	}

}

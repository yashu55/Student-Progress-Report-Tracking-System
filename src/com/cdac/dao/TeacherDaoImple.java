package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Teacher;

@Repository
public class TeacherDaoImple implements TeacherDao {

	@Autowired
	HibernateTemplate ht;

	@Override
	public void addTeacher(Teacher teacher) {
		ht.execute(new HibernateCallback<Void>() {
			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				teacher.setTeacherType("Module_Teacher");
				session.save(teacher);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});

	}

	@Override
	public List<Teacher> selectAllTeacherAdmin() {

		return ht.execute(new HibernateCallback<List<Teacher>>() {

			@Override
			public List<Teacher> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Teacher");
				List<Teacher> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public List<Teacher> selectAllTeacher() {

		return ht.execute(new HibernateCallback<List<Teacher>>() {

			@Override
			public List<Teacher> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Teacher where TeacherType != ?");
				q.setString(0, "admin");
				List<Teacher> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public boolean isTeacherValid(Teacher teacher) {
		return ht.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {

				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Teacher where teacherEmail = ? and teacherPass = ?");
				q.setString(0, teacher.getTeacherEmail());
				q.setString(1, teacher.getTeacherPass());
				List<Teacher> li = q.list();
				boolean flag = !li.isEmpty();
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
		});
	}

	@Override
	public boolean deleteTeacher(int teacherId) {

		return ht.execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {

				Transaction tr = session.beginTransaction();

				Teacher teacher = (Teacher) session.get(Teacher.class, teacherId); // new Teacher(teacherId);
				if (teacher == null) {
					return false;
				}
				session.delete(teacher);
				tr.commit();
				session.flush();
				session.close();
				return true;
			}
		});
	}

	@Override
	public Teacher getTeacher(int teacherId) {
		return ht.execute(new HibernateCallback<Teacher>() {

			@Override
			public Teacher doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Teacher where TeacherId = ?");
				q.setInteger(0, teacherId);
				List<Teacher> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li.get(0);
			}
		});
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		return ht.execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.update(teacher);
				tr.commit();
				session.flush();
				session.close();
				return true;
			}
		});
	}

	@Override
	public Teacher getTeacherByEmail(String teacherEmail) {
		return ht.execute(new HibernateCallback<Teacher>() {
			@Override
			public Teacher doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Teacher where teacherEmail = ?");
				q.setString(0, teacherEmail);
				List<Teacher> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li.get(0);
			}
		});
	}
}

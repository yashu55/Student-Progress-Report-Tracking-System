package com.cdac.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Module;
import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Task;
import com.cdac.dto.Teacher;

@Repository
public class StudentsTasksDaoImple implements StudentsTasksDao {

	@Autowired
	HibernateTemplate ht;
	
	@Override
	public List<Students_Tasks> getStudentTaskByStudent(Student student) {
		return ht.execute(new HibernateCallback<List<Students_Tasks>>() {

			@Override
			public List<Students_Tasks> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Criteria q = session.createCriteria(Students_Tasks.class);
				q.add(Restrictions.eq("student", student));
				List <Students_Tasks> li = q.list();
				System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public Students_Tasks getStudentTaskByStudentAndTask(Student student, Task task) {
		return ht.execute(new HibernateCallback<Students_Tasks>() {

			@Override
			public Students_Tasks doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Criteria q = session.createCriteria(Students_Tasks.class);
				System.out.println("in dao");
				q.add(Restrictions.and(Restrictions.eq("student", student), Restrictions.eq("task", task)));
				List <Students_Tasks> li = q.list();
				System.out.println("in dao 1");				
				System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li.get(0);
			}
		});
	}

	@Override
	public Students_Tasks getStudentTasks(int Students_Tasks_ID) {
		return ht.execute(new HibernateCallback<Students_Tasks>() {

			@Override
			public Students_Tasks doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Students_Tasks where Students_Tasks_ID = ?");
				q.setInteger(0,Students_Tasks_ID);
				List <Students_Tasks> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li.get(0);
			}
		});
	}

	@Override
	public boolean changeTaskStatus(int taskStatus, int Students_Tasks_ID) {
		return ht.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Students_Tasks st =(Students_Tasks)session.get(Students_Tasks.class, Students_Tasks_ID);
				boolean rt = false;
				if(st.getTaskStatus() == taskStatus) {
					rt = false;
				}else {
					st.setTaskStatus(taskStatus);
					rt = true;
				}
				tr.commit();
				session.flush();
				session.close();
				return rt;
			}
		});
	}

	@Override
	public boolean changeTaskMarks(int marks, int Students_Tasks_ID) {
		return ht.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Students_Tasks st =(Students_Tasks)session.get(Students_Tasks.class, Students_Tasks_ID);
				st.setMarks(marks);
				tr.commit();
				session.flush();
				session.close();
				return true;
			}
		});
	}

}

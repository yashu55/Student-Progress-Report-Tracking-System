package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.cdac.dto.Module;
import com.cdac.dto.TaskType;

@Repository
public class TaskTypeDaoImple implements TaskTypeDao {

	@Autowired
	HibernateTemplate ht;
	
	@Override
	public List<TaskType> selectAllTaskType() {
		return ht.execute(new HibernateCallback<List<TaskType>>() {

			@Override
			public List<TaskType> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from TaskType");
				List <TaskType> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public TaskType getTaskType(int taskTypeID) {
		
		
		return ht.execute(new HibernateCallback<TaskType>() {
		@Override
		public TaskType doInHibernate(Session session) throws HibernateException {
			System.out.println("Yash");
			Transaction tr = session.beginTransaction();
			Query q= session.createQuery("from TaskType where taskTypeID  = ?");
			q.setInteger(0,taskTypeID);
			List <TaskType> li = q.list();
			//System.out.println(li.get(0));
			tr.commit();
			session.flush();
			session.close();
			return li.get(0);
		}
	});
	}

	@Override
	public void addTaskType(TaskType taskType) {
		ht.execute(new HibernateCallback<Void>() {	
			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(taskType);
				tr.commit();
				session.flush();
				session.close();
				return null;
			} 
		});
		
	}

}

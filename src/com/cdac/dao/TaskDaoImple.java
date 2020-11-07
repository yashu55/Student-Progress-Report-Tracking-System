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
import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Task;
import com.cdac.service.StudentService;

@Repository
public class TaskDaoImple implements TaskDao {


	@Autowired
	HibernateTemplate ht;
	
	@Autowired
	StudentService studentService;
	
//	@Autowired
//	Students_Tasks stu;
	
	
	@Override
	public void addTask(Task task) {
		ht.execute(new HibernateCallback<Void>() {	
			@Override
			public Void doInHibernate(Session session) throws HibernateException {

				Transaction tr = session.beginTransaction();
				List<Student> allStudents = studentService.selectAllStudent();
				
				for(Student s : allStudents) {
					Students_Tasks stu_task = new Students_Tasks();
					stu_task.setStudent(s);
					stu_task.setTask(task);
					session.save(stu_task);

				}
				session.save(task);

				
				
//				System.out.println("1");
//				for(Student s : allStudents) {
//					task.getAllStudents().add(s);
//				}
//				session.save(task);
//				System.out.println("2");
//
//				tr.commit();
//				System.out.println("3");
//
//				tr = session.beginTransaction();
//				for(Student s : allStudents){
//					Student stud = (Student) session.get(Student.class, s.getStudentRollNo());
//					stud.getAllTasks().add(task);
//					System.out.println("A");
//				}
////				for(Student s : allStudents){
////					session.save(s);
////				}
				tr.commit();
				session.flush();
				session.close();
				return null;
			} 
		});

	}

	@Override
	public List<Task> selectAllTasks() {
		return ht.execute(new HibernateCallback<List<Task>>() {

			@Override
			public List<Task> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Task");
				List <Task> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public List<Task> getTasksByModuleList(List<Module> moduleList) {
		return ht.execute(new HibernateCallback<List<Task>>() {

			@Override
			public List<Task> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Criteria q = session.createCriteria(Task.class);
				q.add(Restrictions.in("module", moduleList));
				List <Task> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

}

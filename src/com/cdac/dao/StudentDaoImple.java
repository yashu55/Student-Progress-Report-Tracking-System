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

import com.cdac.dto.Student;
import com.cdac.dto.Students_Tasks;
import com.cdac.dto.Task;
import com.cdac.dto.Teacher;
import com.cdac.service.TaskService;

@Repository
public class StudentDaoImple implements StudentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Autowired
	private TaskService taskService;
	
	@Override
	public void addStudent(Student student) {
		ht.execute(new HibernateCallback<Void>() {	
			@Override
			public Void doInHibernate(Session session) throws HibernateException {

				Transaction tr = session.beginTransaction();
				List<Task> li = taskService.selectAllTasks();
				
				for(Task t : li) {
					Students_Tasks stu_task = new Students_Tasks();
					stu_task.setTask(t);
					stu_task.setStudent(student);
					session.save(stu_task);

				}
				
				session.save(student);
				
//				for(Task t : li) {
//					student.getAllTasks().add(t);
//				}
//				session.save(student);
//				tr.commit();
//				tr = session.beginTransaction();
//				for(Task t : li) {
//					Task tas = (Task) session.get(Task.class, t.getTaskID());
//					tas.getAllStudents().add(student);
//				}
////				for(Task t : li) {
////					session.save(t);
////				}
////				
				tr.commit();
				session.flush();
				session.close();
				return null;
			} 
		});
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> selectAllStudent() {
		return ht.execute(new HibernateCallback<List<Student>>() {

			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Student");
				List <Student> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
	}

	@Override
	public boolean isStudentValid(Student student) {
		return ht.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {

				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Student where studentEmail = ? and studentPass = ?");
				q.setString(0,student.getStudentEmail());
				q.setString(1,student.getStudentPass());
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
	public Student getStudentbyEmailID(String mailID) {
		return ht.execute(new HibernateCallback<Student>() {

			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Student where studentEmail  = ?");
				q.setString(0,mailID);
				List <Student> li = q.list();
				tr.commit();
				session.flush();
				session.close();
				return li.get(0);
			}
		});
	}

	@Override
	public Student getStudentbyRollNo(String rollNo) {
		return ht.execute(new HibernateCallback<Student>() {

			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q= session.createQuery("from Student where studentRollNo  = ?");
				q.setString(0,rollNo);
				List <Student> li = q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li.get(0);
			}
		});
	}

	@Override
	public void updateStudentforRollNo(String rollNo, String email, String pass, String phoneNo) {
		 ht.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Student student = (Student)session.get(Student.class, rollNo);
				student.setStudentEmail(email);
				student.setStudentPass(pass);
				student.setStudentPhone(phoneNo);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

}



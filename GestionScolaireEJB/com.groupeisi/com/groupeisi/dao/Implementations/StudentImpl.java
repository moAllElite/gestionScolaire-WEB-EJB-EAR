package com.groupeisi.dao.Implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.dao.Interfaces.IStudentLocal;
import com.groupeisi.dao.Interfaces.IStudentRemote;
//import com.groupeisi.entities.RepositoryImpl;
import com.groupeisi.entities.Student;

@Stateless
public class StudentImpl	 	implements	IStudentLocal,	 IStudentRemote{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "gestionScolaire")//permet de scan notre  persistence.xml
	private EntityManager entityManager;
	@Override
	public List<Student> list(Student student) {
		return	entityManager.createQuery("SELECT s FROM student s").getResultList();
	}

	@Override
	public int add(Student student) {
		int isValide=1;
		entityManager.persist(student);
		return isValide;
	}

	@Override
	public int delete(int id, Student student) {
		int ok=1;
		student=(Student) entityManager.createQuery("SELECT t FROM student t WHERE t.id=:id").setParameter("id", id).getSingleResult();
		entityManager.remove(student);
		return ok;
	}

	@Override
	public int update(Student student) {
		int ok=0;
		try {
			ok=1;
			entityManager.merge(student);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}

	
	@Override
	public Student getStudent(int id) {
		return  (Student) entityManager.createQuery("SELECT s FROM student s WHERE s.id=:id").setParameter("id", id).getSingleResult();
	}

	@Override
	public Student get(int id, Student t) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

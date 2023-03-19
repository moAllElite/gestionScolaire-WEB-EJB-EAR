package com.groupeisi.dao.Implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.dao.Interfaces.ICoursesLocal;
import com.groupeisi.dao.Interfaces.ICoursesRemote;
import com.groupeisi.entities.Courses;
@Stateless
public class CourseImpl implements ICoursesRemote, ICoursesLocal {
	@PersistenceContext(unitName = "gestionScolaire")//permet de scan notre  persistence.xml
	private EntityManager en;
	
	@Override
	public int add(Courses courses) {
		// TODO Auto-generated method stub
		int ok=1;
		en.persist(courses);
		return ok;
	}

	@Override
	public int delete(int id, Courses courses) {
		// TODO Auto-generated method stub
		int ok=1;
		courses=(Courses) en.createQuery("SELECT c FROM Courses c WHERE id=:id").setParameter("id", id).getSingleResult();
		en.remove(courses);
		return ok;
	}

	@Override
	public int update(Courses courses) {
		// TODO Auto-generated method stub
		int ok=1;
		en.merge(courses);
		return ok;
	}

	@Override
	public List<Courses> list(Courses courses) {	
		return en.createQuery("SELECT  c FROM Courses c").getResultList();
	}

	@Override
	public Courses get(int id, Courses t) {
		// TODO Auto-generated method stub
		return null;
	}

}

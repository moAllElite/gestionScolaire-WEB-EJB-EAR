package com.groupeisi.dao.Implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.dao.Interfaces.ICoursesRemote;
import com.groupeisi.entities.Courses;
@Stateless
public class CoursesImpl extends RepositoryImpl<Courses>	implements ICoursesRemote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "gestionScolaire")
	public EntityManager entityManager;
	@Override
	public List<Courses> list(Courses courses) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT c FROM course c").getResultList();
	}

	@Override
	public int add(Courses courses) {
		int isValide=0;
		try {
			
			//on fait persister l'objet courses
			entityManager.persist(courses);
			//si tout se passe bien isvalide vaut1
			isValide=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isValide;
	}

}

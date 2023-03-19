package com.groupeisi.dao.Implementations;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.dao.Interfaces.IRepository;
@Stateless
public class RepositoryImpl<T> implements IRepository<T> ,Serializable {

	/**
	 * 
	 */
	@PersistenceContext(unitName = "gestionScolaire")
	protected EntityManager en;
	private static final long serialVersionUID = 1L;

	@Override
	public int add(T t) {
		int ok=1;
		en.persist(t);
		return ok;
	}

	@Override
	public int delete(int id, T t) {
		int ok=1;
		String table =t.getClass().getSimpleName();
		t=(T) en.createQuery("SELECT t FROM "+table+" t WHERE t.id=:id").setParameter("id", id).getSingleResult();
		en.remove(t);
		return ok;
	}

	@Override
	public int update(T t) {
		int ok=0;
		try {
			en.merge(t);
			ok=1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public List<T> list(T t) {
		// TODO Auto-generated method stub
		String table=t.getClass().getSimpleName();
		return en.createQuery("SELECT  t FROM "+table+" t").getResultList();
	}

	@Override
	public T get(int id,T t) {
		String table=t.getClass().getSimpleName();
		return (T) en.createQuery("SELECT t FROM "+table+"t WHERE t.id=:id").setParameter("id",id).getSingleResult();
	}

}

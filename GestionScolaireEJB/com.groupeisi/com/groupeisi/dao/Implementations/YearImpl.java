package com.groupeisi.dao.Implementations;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.dao.Interfaces.IYearLocal;
import com.groupeisi.dao.Interfaces.IYearRemote;
import com.groupeisi.entities.Year;
@Stateless
public class YearImpl implements	IYearLocal, IYearRemote{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "gestionScolaire")
	private EntityManager en;
	
	public int add(Year year) {
		int ok=0;
		try {
			 ok=1;
			en.persist(year);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ok;
	}
	@Override
	public int delete(int id, Year year) {
		// TODO Auto-generated method stub
		int ok=1;
		year=(Year) en.createQuery("SELECT y FROM Year y WHERE y.id=:id ").setParameter("id", id).getSingleResult();
		en.remove(year);
		return ok;
	}
	@Override
	public int update(Year year) {
		int ok=1;
		en.merge(year);
		return ok;
	}
	@Override
	public List<Year> list(Year year) {
		// TODO Auto-generated method stub
		return   en.createQuery("SELECT y FROM Year y").getResultList();
	}
	@Override
	public Year get(int id, Year year) {
		String table=year.getClass().getSimpleName();
		return (Year) en.createQuery("SELECT y FROM "+table.substring(0, 1).toUpperCase() + table.substring(1)+" WHERE y.id=:id").setParameter("id", id).getSingleResult();
	}
	@Override
	public Year getYear(int id) {
		return (Year) en.createQuery("SELECT y FROM Year y WHERE y.id=:id").setParameter("id", id).getSingleResult();

	}

}

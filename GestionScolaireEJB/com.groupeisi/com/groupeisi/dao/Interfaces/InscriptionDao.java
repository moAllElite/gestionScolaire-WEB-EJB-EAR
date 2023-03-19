package com.groupeisi.dao.Interfaces;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Inscription;
@Stateless
public class InscriptionDao 	implements IInscriptionLocal, IInscriptionRemote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "gestionScolaire")//permet de scan notre  persistence.xml
	public EntityManager en;
	@Override
	public List<Inscription> list(Inscription inscription) {
		// TODO Auto-generated method stub
		return en.createQuery("SELECT i FROM Inscription i").getResultList();
	}

	@Override
	public int add(Inscription inscription) {
		int ok=1;
			//persistance de l'objet inscription
			en.persist(inscription);
			//si tout se passe bien ok vaut 1
		return ok;
	}

	@Override
	public int delete(int id, Inscription i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Inscription i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Inscription get(int id, Inscription t) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.groupeisi.dao.Interfaces;

import javax.ejb.Local;

import com.groupeisi.entities.Year;

@Local
public interface IYearLocal extends IRepository<Year>{
	public Year getYear(int id);
}

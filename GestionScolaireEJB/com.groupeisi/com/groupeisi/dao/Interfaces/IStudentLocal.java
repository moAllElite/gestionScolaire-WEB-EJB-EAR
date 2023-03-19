package com.groupeisi.dao.Interfaces;


import javax.ejb.Local;

//import com.groupeisi.entities.IRepository;
import com.groupeisi.entities.Student;





@Local
public interface IStudentLocal extends IRepository<Student>{
	public Student getStudent(int id);
	
}

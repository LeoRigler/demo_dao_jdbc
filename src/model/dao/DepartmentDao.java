package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	/*
	 * Aqui é a interface do Seller/Department
	 */
	
	void insert(Department obj); 
	void update (Department obj); 
	void deleteById(Integer id); 
	Department findById(Integer id); 
	List<Department> findAll(); 
	

}

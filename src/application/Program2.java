package application;

import java.util.Scanner;

import model.dao.DepartmentDao;
import model.dao.impl.DaoFactory;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1 : Department Insert =====");
		System.out.println("Enter ID Department for insert");
		int id = sc.nextInt(); 
		sc.nextLine();
		System.out.println("Enter name Department for insert");
		String name = sc.nextLine();
		Department newDepartment = new Department(id, name);
		departmentDao.insert(newDepartment);
		System.out.println("Dados inseridos com sucesso!!! ");
	
		
		
		sc.close();
	}

}

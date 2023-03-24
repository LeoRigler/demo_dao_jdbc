package application;

import java.util.List;
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
		
		System.out.println("=== Test 2 : Department FindAll =====");
		List<Department> list = departmentDao.findAll(); 
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== Test 3 : Department Update =====");
		System.out.println("Insert the Id would be updated: ");
		id = sc.nextInt(); 
		sc.nextLine(); 
		System.out.println("Now insert the new name: ");
		name = sc.nextLine(); 
		newDepartment = new Department(id, name);
		departmentDao.update(newDepartment);
		System.out.println(id + " updated with sucess!!!");
		
		System.out.println("=== Test 4 : Department Delete =====");
		System.out.println("Enter id for delete test: ");
		id = sc.nextInt(); 
		sc.nextLine(); 
		departmentDao.deleteById(id);
		System.out.println("Delete completed!!");
		
		System.out.println("=== Test 5 : Department find by ID =====");
		System.out.println("Enter id to find department: ");
		id = sc.nextInt(); 
		sc.nextLine(); 
		newDepartment = departmentDao.findById(id);
		System.out.println(newDepartment);
		
		
		sc.close();
	}

}

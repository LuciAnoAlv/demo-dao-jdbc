package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1 Department findById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TESTE 2 Department findAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 3 Department insert ===");
		Department newDepartment = new Department(null, "Fisica");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 4 Department Update ===");
		department = departmentDao.findById(5);
		department.setName("Quimica");
		departmentDao.update(department);
		System.out.println("Update completed");
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 5 Department delete ===");
		System.out.println("Enter id for delete:");
		departmentDao.deleteById(6);
		System.out.println("Delete Completed");
		list = departmentDao.findAll();
		list.forEach(System.out::println);
		
	}

}

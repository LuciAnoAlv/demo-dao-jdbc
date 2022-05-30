package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1 Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2 Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		/*
		for (Seller s: list) {
			System.out.println(s);
		}
		*/
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 3 Seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		
		list2.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 4 Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TESTE 5 Seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TESTE 6 Seller delete ===");
		System.out.println("Enter id for delete:");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed");
		
		sc.close();
	}

}

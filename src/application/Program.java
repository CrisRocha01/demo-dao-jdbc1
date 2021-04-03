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
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("    ======  TEST 1: seller findById  ======");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n    ======  TEST 2: seller findByDepartment  ======");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n    ======   TEST 3: seller findAll   ======");
		
		list = sellerDao.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n    ======   TEST 4: seller insert   ======");
		Seller sel = new Seller(null, "Roberto Carneiro", "bob@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(sel);
		System.out.println("Inserted! new id = " + sel.getId());
		
		System.out.println("\n    ======   TEST 5: seller update   ======");
		sel = sellerDao.findById(1);
		sel.setName("Abdias");
		sellerDao.update(sel);
		System.out.println("Row updated: \n" + sellerDao.findById(1));
		
		System.out.println("\n    ======   TEST 6: seller delete   ======");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informa o id a ser deletado: ");
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		
		sc.close();
		
		
		
		

	}

}

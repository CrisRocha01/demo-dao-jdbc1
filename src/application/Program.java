package application;


import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		

		Department dt = new Department(1, "teste");
		
		Seller sl = new Seller(12, "name", "email", new Date(), 3000.0, dt);
		
		System.out.println(dt);
		System.out.println(sl);

	}

}

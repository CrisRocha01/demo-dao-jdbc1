package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createdepartmentDao();
		
		System.out.println("    ======  TEST 1: department findById  ======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n    ======  TEST 2: department findAll  ======");
		List<Department> list = departmentDao.findAll();
		for(Department obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n    ======  TEST 3: department insert  ======");
		Department department = new Department(null, "UnderWear");
		departmentDao.insert(department);
		System.out.println(department + "inserido");
		
		System.out.println("\n    ======  TEST 4: department update  ======");
		department = departmentDao.findById(9);
		department.setName("Stuff");
		departmentDao.update(department);
		System.out.println("Id " + department.getId() + " UpDated");

	}

}

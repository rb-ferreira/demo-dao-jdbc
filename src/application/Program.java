package application;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		/*Department obj = new Department(1,"Books");
		Seller seller = new Seller(21,"bob","bob@gmail.com", new Date(), 3000.0, obj);*/
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("**** APLICATION TESTE: 1 - RECURSO: FINDBYID ****");
		Seller seller = sellerDao.findById(3);
		
		//System.out.println(obj);
		System.out.println(seller);
		
		System.out.println("\n**** APLICATION TESTE: 2 - RECURSO: FINDBYDEPARTMENT ****");
		Department department = new Department(2, null);
		
		List<Seller> list = sellerDao.findBydepartment(department);
		
		for(Seller obj : list) {
			
			System.out.println(obj);
		}
		
		System.out.println("\n**** APLICATION TESTE: 3 - RECURSO: FINDALL ****");
				
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			
			System.out.println(obj);
		}
		
		
		
		System.out.println("\n**** APLICATION TESTE: 4 - RECURSO: INSERT ****");
		
		Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 3000.0, department);
		
		sellerDao.insert(newseller);
		
		System.out.println("insert! New id = " + newseller.getId());
		
		System.out.println("\n**** APLICATION TESTE: 5 - RECURSO: UPDATE ****");
		
		seller = sellerDao.findById(1);
		seller.setName("martha Waine");
		sellerDao.update(seller);
		System.out.println("update Completed");
		
		
		System.out.println("\n**** APLICATION TESTE: 6 - RECURSO: DELETE ****");
		System.out.println("Enter id for selete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		sc.close();
		
		
		

	}

}

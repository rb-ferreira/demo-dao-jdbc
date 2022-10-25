package application;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		/*Department obj = new Department(1,"Books");
		Seller seller = new Seller(21,"bob","bob@gmail.com", new Date(), 3000.0, obj);*/
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("**** APLICATION TESTE: 1 - RECURSO: FINDBYID ****");
		Seller seller = sellerDao.findById(3);
		
		//System.out.println(obj);
		System.out.println(seller);
		
		System.out.println("\n**** APLICATION TESTE: 1 - RECURSO: FINDBYDEPARTMENT ****");
		Department department = new Department(2, null);
		
		List<Seller> list = sellerDao.findBydepartment(department);
		
		for(Seller obj : list) {
			
			System.out.println(obj);
		}

	}

}

package com.mycompany.app;

import java.util.Scanner;

import com.mycompany.dao.ProductManagementDAO;
import com.mycompany.dbutil.DBUtil;
import com.mycompany.domain.Product;
public class ProductManagementApp {
	
	public static void main(String[] args) {
		int choice,num;
		
		ProductManagementDAO dao = new DBUtil();
		Product e;
		
		do {
			System.out.println("\n*******   Product Managment Application.com *******");
			System.out.println("<-------Menu------>");
			System.out.println("1.Get Product details by ID");
			System.out.println("2.Add Product");
			System.out.println("3.Update Product");
			System.out.println("4.Delete Product");
			System.out.println("5.Get all Product");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: System.out.println("Enter the ID of Product: ");
				String id1 = sc.next();
				e = dao.getProductById(id1);
			break;
			
		case 2: System.out.println("Enter Product Details: ");
				System.out.println("Enter Product ID: ");
				String id2 = sc.next();
				System.out.println("Enter Product Name: ");
				String name = sc.next();
				System.out.println("Enter Salary: ");
				int price = sc.nextInt();
				Product product = new Product(id2, name, price);
				e = dao.addProduct(product);
			break;
			
		case 3:	System.out.println("Enter the product ID to change record: ");
				String id3 = sc.next();
				System.out.println("Enter the new product Name: ");
				String name1 = sc.next();
				e = dao.updateProduct(id3, name1);
			break;
			
		case 4: System.out.println("Enter the product ID to delete record");
				String id4 = sc.next();
				e = dao.deleteProduct(id4);
				break;
			
		case 5: System.out.println("Product Details");
				System.out.println("-----------------------------");
				System.out.printf("|%5s|%-10s|%-10s|\n", "Product ID", "Product Name", "Product Price");
				System.out.println("-----------------------------");
				dao.getAllProducts();
				System.out.println("-----------------------------");
				break;
		default:
			System.out.println("Wrong input..!"); 
			break;
		}
		System.out.println("Enter 9 to continue..!");
		num = sc.nextInt();
		}while(num == 9);
	}

}

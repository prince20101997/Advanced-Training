package com.mycompany.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mycompany.dao.ProductManagementDAO;
import com.mycompany.domain.Product;

public class DBUtil extends ProductManagementDAO {
		
		public static final String URLTOCONNECT = "jdbc:mysql://localhost:3306/productdb";


	    public static final String USERNAME = "root";


	    public static final String PASSWORD = "prince@12345";
	    
	    private Connection dbCon;
	    
		public DBUtil() {
			// TODO Auto-generated constructor stub
		}

		Product product = new Product();

		public void getAllProducts() {
			try
			{
				String query = "select * from product";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            Connection dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, PASSWORD);
				Statement st = dbCon.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next())
				{		
					String id = rs.getString(1);
					product.setProduct_id(id);
					String name = rs.getString(2);
					product.setProduct_name(name);
					int price = rs.getInt(3);
					product.setProduct_price(price);
					System.out.printf("|%5s    |%-10s    |%-10s|\n", id, name, price);
				}
				
				rs.close();
				st.close();
				dbCon.close();
			}
			catch (SQLException e ) {		
				e.printStackTrace();
				}
			}
		
			@Override
			public Product getProductById(String ID) {
				try
				{
					String query = "select * from product where product_id= "+ID;
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            Connection dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, PASSWORD);
					Statement st = dbCon.createStatement();
					ResultSet rs = st.executeQuery(query);
						while(rs.next())
						{					
							String id = rs.getString(1);
							product.setProduct_id(id);
							String name = rs.getString(2);
							product.setProduct_name(name);
							int price = rs.getInt(3);
							product.setProduct_price(price);
							
							System.out.println("         Product Details          ");
							System.out.println("-----------------------------");
							System.out.printf("|%5s|%-10s|%-10s|\n", "Product ID", "Product Name", "Product Price");
							System.out.println("-----------------------------");
							System.out.printf("|%5s    |%-10s   |%-10s   |\n", id, name, price);
							System.out.println("-----------------------------");
						}
					
					
					rs.close();
					st.close();
					dbCon.close();
				}
				catch ( SQLException e) {		
					e.printStackTrace();
				}
				return product;
			}
		
				
			@Override
			public Product addProduct(Product product) {
				try {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            Connection dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, PASSWORD);
			        PreparedStatement ps = dbCon.prepareStatement("INSERT INTO product VALUES (?, ?, ?)");
			       ps.setString(1, product.getProduct_id());
			       ps.setString(2, product.getProduct_name());
			       ps.setInt(3, product.getProduct_price());
			      int i =  ps.executeUpdate();
			      if(i > 0) {
			    	  System.out.println("Product added successfully...!");		      	     
			      }
			      else
			    	  System.out.println("Failed to add a product details........!");
			      ps.close();
			      dbCon.close();
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
				
			}
		
			@Override
			public Product deleteProduct(String ID) {
				try
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            Connection dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, PASSWORD);
					
					String sql = "DELETE FROM product WHERE product_id=?";
					PreparedStatement ps = dbCon.prepareStatement(sql);
					ps.setString(1, ID);
													 
					int i = ps.executeUpdate();
					if (i > 0) {
					    System.out.println("Data deleted successfully!");
					}
					else
						System.out.println("Failed to delete data..!");
					
					ps.close();
					dbCon.close();
					
				}catch (SQLException ex) {
			        ex.printStackTrace();
			    }
				return null;
				
			}


			@Override
			public Product updateProduct(String ID, String name) {
				try
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
		            Connection dbCon = DriverManager.getConnection(URLTOCONNECT, USERNAME, PASSWORD);
					String sql = "UPDATE product SET product_name= ? WHERE product_id=?";
					PreparedStatement ps = dbCon.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2, ID);
									 
					int i = ps.executeUpdate();
					if (i > 0) {
					    System.out.println("An existing product details was updated successfully!");
					}
					else
						System.out.println("Failed to update data..!");
					
					ps.close();
					dbCon.close();
					
				}catch (SQLException ex) {
			        ex.printStackTrace();
			    }
				return null;
				
			}

	}


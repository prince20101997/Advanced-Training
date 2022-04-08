package com.mycompany.domain;

public class Product {

	String product_id;
	String product_name;
	int product_price;
	
	//constructor
	public Product(String p_id, String p_name, int p_price) {
		super();
		this.product_id = p_id;
		this.product_name = p_name;
		this.product_price = p_price;
	}
	//getter setters
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String id) {
		this.product_id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Product ID=" + product_id + ",Product Name=" + product_name + ", Product Price=" + product_price;
	}

}

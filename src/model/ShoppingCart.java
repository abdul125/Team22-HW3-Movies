package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ShoppingCartItem> items;
	private String customerUserName;	
	
	public ShoppingCart (){
		
	}

	public ShoppingCart(ArrayList<ShoppingCartItem> items, String customerUserName) {
		super();
		this.items = items;
		this.customerUserName = customerUserName;
	}

	public ArrayList<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<ShoppingCartItem> items) {
		this.items = items;
	}

	public String getCustomerUserName() {
		return this.customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

}

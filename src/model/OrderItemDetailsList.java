package model;

import java.util.ArrayList;

public class OrderItemDetailsList {
	private ArrayList<OrderItemDetails> items;
	
	public OrderItemDetailsList(){
		
	}

	public OrderItemDetailsList(ArrayList<OrderItemDetails> items){
		super();
		this.items = items;
	}

	public ArrayList<OrderItemDetails> getItems() {
		return this.items;
	}

	public void setItems(ArrayList<OrderItemDetails> items) {
		this.items = items;
	}
	
	
}

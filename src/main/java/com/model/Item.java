package com.model;

import javax.persistence.*;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private int itemId;
	private String itemName;
	private float price;
	private int quantity;
	public Item() {}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(int itemId, String itemName, float price, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
}


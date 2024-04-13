package com.ship.and.drop.inventory.representations;

import lombok.Data;

//@Data
public class InventoryPropertiesMedia {

	long id = 0;
	String title;
	String quantity;
	String priceofItem;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPriceofItem() {
		return priceofItem;
	}
	public void setPriceofItem(String priceofItem) {
		this.priceofItem = priceofItem;
	}

}

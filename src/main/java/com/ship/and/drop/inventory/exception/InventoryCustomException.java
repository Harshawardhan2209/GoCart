package com.ship.and.drop.inventory.exception;

import lombok.Data;

@Data
public class InventoryCustomException {

	private String errorCode;
	private String message;
	private String description;
	
	public InventoryCustomException(String errorCode, String message, String description) {
		this.errorCode = errorCode;
		this.description = description;
		this.message = message;
	}
}

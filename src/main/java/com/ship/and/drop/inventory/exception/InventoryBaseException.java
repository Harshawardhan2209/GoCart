package com.ship.and.drop.inventory.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InventoryBaseException extends Exception {

	public InventoryBaseException(String errorCode, String apiName, InventoryCustomException customException) {
		this.customException = customException;
		this.errorCode = errorCode;
		this.apiName = apiName;
	}
	
	private static final long serialVersionUID = 5722683428999476528L;
	private String errorCode;
	private String apiName;
	private Exception e;
	private InventoryCustomException customException;

}

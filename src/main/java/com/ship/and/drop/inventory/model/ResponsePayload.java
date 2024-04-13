package com.ship.and.drop.inventory.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePayload {
	private String status;
	private String code;
	private String message;
	private String description;
	@JsonIgnore
	private HttpStatus httpErrorCode;
	private Object data;

	public ResponsePayload(Object data, HttpStatus httpErrorCode, String code) {
		this.code = code;
		this.data = data;
		this.httpErrorCode = httpErrorCode;
	}

}

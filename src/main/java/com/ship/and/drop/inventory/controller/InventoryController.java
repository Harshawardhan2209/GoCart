package com.ship.and.drop.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ship.and.drop.inventory.exception.InventoryBaseException;
import com.ship.and.drop.inventory.exception.InventoryCustomException;
import com.ship.and.drop.inventory.model.InventoryEntity;
import com.ship.and.drop.inventory.model.ResponsePayload;
import com.ship.and.drop.inventory.representations.InventoryPropertiesMedia;
import com.ship.and.drop.inventory.service.InventoryService;

@Component
@RestController
public class InventoryController {
	
	@Autowired
	InventoryService service;

	@PostMapping(value = "/inventory", consumes = {"application/json"},
            produces = {"application/json"})
	public ResponseEntity<ResponsePayload> createInventory(@RequestBody InventoryPropertiesMedia inventoryResource) throws InventoryBaseException
	{
		validateInventoryPropertiesMediaResource(inventoryResource);
		InventoryEntity inventoryToSave = convertFromInventoryPropertiesMedia(inventoryResource);
		InventoryEntity inventorySaved = service.saveInventory(inventoryToSave);
		InventoryPropertiesMedia media = convertToInventoryPropertiesMedia(inventorySaved);
		ResponsePayload response = new ResponsePayload(media, HttpStatus.OK, "000");
		return new ResponseEntity<ResponsePayload>(response, response.getHttpErrorCode());
	}

	private void validateInventoryPropertiesMediaResource(InventoryPropertiesMedia resource) throws InventoryBaseException {
		if(resource.getTitle() == null) {
			throw new InventoryBaseException("1009", "/inventory", new InventoryCustomException("1009", "Title cannot be null", "Enter title and try again"));
		}
	}
	
	private InventoryEntity convertFromInventoryPropertiesMedia(InventoryPropertiesMedia inventoryResourceMedia) {
		InventoryEntity inventoryEntity = new InventoryEntity();
		inventoryEntity.setQuantity(inventoryResourceMedia.getQuantity());
		inventoryEntity.setTitle(inventoryResourceMedia.getTitle());
		return inventoryEntity;
	}
	
	private InventoryPropertiesMedia convertToInventoryPropertiesMedia(InventoryEntity inventoryEntity) {
		InventoryPropertiesMedia inventoryResourceMedia = new InventoryPropertiesMedia();
		inventoryEntity.setQuantity(inventoryEntity.getQuantity());
		inventoryEntity.setTitle(inventoryEntity.getTitle());
		return inventoryResourceMedia;
	}
	
	
	
}

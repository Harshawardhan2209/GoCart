package com.ship.and.drop.inventory.service;


import org.springframework.stereotype.Service;

import com.ship.and.drop.inventory.model.InventoryEntity;

@Service
public interface InventoryService {

	InventoryEntity saveInventory(InventoryEntity inventoryEntity);

}

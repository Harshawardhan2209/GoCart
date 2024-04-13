package com.ship.and.drop.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ship.and.drop.inventory.model.InventoryEntity;
import com.ship.and.drop.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
//	@Qualifier("inventoryRepository")
	private InventoryRepository repository;
//	
	@Override
	public InventoryEntity saveInventory(InventoryEntity inventoryEntity) {
		InventoryEntity saved = repository.save(inventoryEntity);
		return saved;
//		return null;
	}
	
}

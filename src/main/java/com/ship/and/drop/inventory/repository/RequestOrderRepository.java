package com.ship.and.drop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ship.and.drop.inventory.model.InventoryEntity;

@Repository
public interface RequestOrderRepository extends JpaRepository<InventoryEntity, Long> {

}

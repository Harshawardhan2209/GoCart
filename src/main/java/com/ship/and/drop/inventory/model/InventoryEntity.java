package com.ship.and.drop.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "INVENTORY")
@EqualsAndHashCode(callSuper = true)
public class InventoryEntity extends JpaTrackedObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INVENTORY_ID", insertable = false, updatable = false)
	private long inventoryId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "QUANTITY")
	private String quantity;

	@Column(name = "CATEGORY")
	private String category;
	
}

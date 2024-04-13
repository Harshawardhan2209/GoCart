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
@Table(name = "REQUEST_ORDER")
@EqualsAndHashCode(callSuper = true)
public class RequestOrderEntity extends JpaTrackedObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQUEST_ORDER_ID", insertable = false, updatable = false)
	private long requestOrderId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "QUANTITY")
	private String quantity;

	@Column(name = "PRICE")
	private double priceOfItem;

}

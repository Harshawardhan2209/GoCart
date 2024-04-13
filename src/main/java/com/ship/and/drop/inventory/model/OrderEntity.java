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
@Table(name = "ORDER")
@EqualsAndHashCode(callSuper = true)
public class OrderEntity extends JpaTrackedObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID", insertable = false, updatable = false)
	private long orderId;

	@Column(name = "INVENTORY_ID", insertable = false, updatable = false)
	private String inventoryId;

	@Column(name = "CUSTOMER_UUID")
	private String customerUUID;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	@Column(name = "PAYMENT_STATUS")
	private String paymentStatus;

	@Column(name = "TRANSIT_MODE")
	private String transitMode;

	@Column(name = "TRANSIT_STATUS")
	private String transitStatus;
}

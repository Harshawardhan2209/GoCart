package com.ship.and.drop.inventory.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@MappedSuperclass
@Data
public class JpaTrackedObject {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DTTM", updatable = true)
	private Date creationTimeStamp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DTTM", updatable = true)
	private Date modifiedTimeStamp;

	@Column(name = "CREATED_BY_NAME", length = 100, updatable = false)
	private String createdBy;

	@Column(name = "MODIFIED_BY_NAME", length = 100, updatable = true)
	private String modifiedBy;

}

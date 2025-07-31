package com.example.trackingapi.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class TrackingNumber {
	
	public TrackingNumber() {
		super();
	}

	public TrackingNumber(Long id, String trackingNumber, OffsetDateTime createdAt) {
		super();
		this.id = id;
		this.trackingNumber = trackingNumber;
		this.createdAt = createdAt;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 16, nullable = false)
    private String trackingNumber;

	@Column(nullable = false)
    private OffsetDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

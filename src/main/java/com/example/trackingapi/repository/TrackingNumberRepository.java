package com.example.trackingapi.repository;

import com.example.trackingapi.model.TrackingNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, Long> {
    boolean existsByTrackingNumber(String trackingNumber);
}

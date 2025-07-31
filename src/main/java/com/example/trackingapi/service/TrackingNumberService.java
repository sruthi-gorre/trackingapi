package com.example.trackingapi.service;

import com.example.trackingapi.model.TrackingNumber;
import com.example.trackingapi.repository.TrackingNumberRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class TrackingNumberService {

    private final TrackingNumberRepository repository;

    public TrackingNumberService(TrackingNumberRepository repository) {
        this.repository = repository;
    }

    public TrackingNumber generateTrackingNumber(String origin, String destination) {
        String base = (origin + destination + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
        String trackingNumber = base.substring(0, 16);

        while (repository.existsByTrackingNumber(trackingNumber)) {
            trackingNumber = (origin + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()).substring(0, 16);
        }

        TrackingNumber tn = new TrackingNumber();
        tn.setTrackingNumber(trackingNumber);
        tn.setCreatedAt(OffsetDateTime.now());
        return repository.save(tn);
    }
}

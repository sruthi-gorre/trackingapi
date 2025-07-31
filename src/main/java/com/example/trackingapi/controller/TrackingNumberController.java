package com.example.trackingapi.controller;

import com.example.trackingapi.model.TrackingNumber;
import com.example.trackingapi.service.TrackingNumberService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/next-tracking-number")
public class TrackingNumberController {

    private final TrackingNumberService service;

    public TrackingNumberController(TrackingNumberService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam double weight,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created_at,
            @RequestParam UUID customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug
    ) {
        TrackingNumber tn = service.generateTrackingNumber(origin_country_id, destination_country_id);
        return Map.of(
                "tracking_number", tn.getTrackingNumber(),
                "created_at", tn.getCreatedAt()
        );
    }
}

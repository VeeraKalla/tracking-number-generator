package com.teleport.logistics.tracking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackingNumberRes {
    private String tracking_number;
    private String created_at;

    public TrackingNumberRes(String trackingNumber, String createdTs) {
        this.tracking_number = trackingNumber;
        this.created_at = createdTs;
    }
}
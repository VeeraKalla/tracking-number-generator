package com.teleport.logistics.tracking.service;

import com.teleport.logistics.tracking.dto.TrackingNumberReq;
import com.teleport.logistics.tracking.dto.TrackingNumberRes;

public interface TNGService {

    /**
     * This method helps to generate the unique tracking number
     *
     * @param trackingNumberReq
     * @return tracking number of length 16 characters
     */
    TrackingNumberRes generateTrackingNumber(TrackingNumberReq trackingNumberReq);
}
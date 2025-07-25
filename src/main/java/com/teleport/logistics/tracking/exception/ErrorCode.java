package com.teleport.logistics.tracking.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    TRACKING_NUM_GENERATION_ERROR("1000", "Tracking number generation failed"),
    UNKNOWN_ERROR("1001", "Unknown error occurred");

    private final String value;
    private final String defaultMessage;

    ErrorCode(String value, String message) {
        this.value = value;
        this.defaultMessage = message;
    }
}

package com.teleport.logistics.tracking.controller;

import com.teleport.logistics.tracking.dto.TrackingNumberReq;
import com.teleport.logistics.tracking.dto.TrackingNumberRes;
import com.teleport.logistics.tracking.service.TNGService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class TNGController {

    private final TNGService tngService;

    @GetMapping("/test")
    public String test() {
        log.info("inside test method");
        return "test application success";
    }

    @PostMapping("/next-tracking-number")
    public ResponseEntity<TrackingNumberRes> getTrackingNumber(@Valid @RequestBody TrackingNumberReq trackingNumberReq) {
        return ResponseEntity.ok(tngService.generateTrackingNumber(trackingNumberReq));
    }


}

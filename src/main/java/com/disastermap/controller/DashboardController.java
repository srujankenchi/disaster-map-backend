package com.disastermap.controller;

import com.disastermap.dto.DashboardSummaryDTO;
import com.disastermap.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(originPatterns = "*")
public class DashboardController {

    private final AnalyticsService analyticsService;

    public DashboardController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/summary")
    public ResponseEntity<DashboardSummaryDTO> getDashboardSummary() {
        DashboardSummaryDTO summary = analyticsService.getDashboardSummary();
        return ResponseEntity.ok(summary);
    }
}

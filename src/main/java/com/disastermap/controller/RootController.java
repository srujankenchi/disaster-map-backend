package com.disastermap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*")
public class RootController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> rootEndpoint() {
        Map<String, Object> info = new HashMap<>();
        info.put("status", "UP");
        info.put("application", "Global Disaster and Human Impact Map API");
        info.put("version", "1.0.0");

        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("dashboardSummary", "/api/dashboard/summary");
        endpoints.put("disasters", "/api/disasters");
        endpoints.put("mapMarkers", "/api/disasters/map");
        endpoints.put("disastersByYear", "/api/analytics/disasters-by-year");
        endpoints.put("disastersByType", "/api/analytics/disasters-by-type");
        endpoints.put("humanImpact", "/api/analytics/human-impact-by-type");
        endpoints.put("countries", "/api/filters/countries");
        info.put("endpoints", endpoints);

        info.put("frontend", "Access the web UI at http://localhost:5173 (or http://localhost:5174)");
        return ResponseEntity.ok(info);
    }
}

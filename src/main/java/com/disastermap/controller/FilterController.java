package com.disastermap.controller;

import com.disastermap.service.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filters")
@CrossOrigin(originPatterns = "*")
public class FilterController {

    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountries() {
        return ResponseEntity.ok(filterService.getCountries());
    }

    @GetMapping("/disaster-types")
    public ResponseEntity<List<String>> getDisasterTypes() {
        return ResponseEntity.ok(filterService.getDisasterTypes());
    }

    @GetMapping("/years")
    public ResponseEntity<List<Integer>> getYears() {
        return ResponseEntity.ok(filterService.getYears());
    }

    @GetMapping("/severities")
    public ResponseEntity<List<String>> getSeverities() {
        return ResponseEntity.ok(filterService.getSeverities());
    }
}

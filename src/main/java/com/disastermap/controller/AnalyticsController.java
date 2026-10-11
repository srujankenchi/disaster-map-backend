package com.disastermap.controller;

import com.disastermap.dto.CountryStatisticDTO;
import com.disastermap.dto.HumanImpactDTO;
import com.disastermap.dto.TypeStatisticDTO;
import com.disastermap.dto.YearStatisticDTO;
import com.disastermap.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(originPatterns = "*")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/disasters-by-year")
    public ResponseEntity<List<YearStatisticDTO>> getDisastersByYear() {
        return ResponseEntity.ok(analyticsService.getDisastersByYear());
    }

    @GetMapping("/disasters-by-type")
    public ResponseEntity<List<TypeStatisticDTO>> getDisastersByType() {
        return ResponseEntity.ok(analyticsService.getDisastersByType());
    }

    @GetMapping("/human-impact-by-type")
    public ResponseEntity<List<HumanImpactDTO>> getHumanImpactByType() {
        return ResponseEntity.ok(analyticsService.getHumanImpactByType());
    }

    @GetMapping("/fatalities-by-country")
    public ResponseEntity<List<CountryStatisticDTO>> getFatalitiesByCountry(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(analyticsService.getFatalitiesByCountry(limit));
    }

    @GetMapping("/affected-population-by-year")
    public ResponseEntity<List<YearStatisticDTO>> getAffectedPopulationByYear() {
        return ResponseEntity.ok(analyticsService.getAffectedPopulationByYear());
    }

    @GetMapping("/economic-damage-by-country")
    public ResponseEntity<List<CountryStatisticDTO>> getEconomicDamageByCountry(
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(analyticsService.getEconomicDamageByCountry(limit));
    }
}

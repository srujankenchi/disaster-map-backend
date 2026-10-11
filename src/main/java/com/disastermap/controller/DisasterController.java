package com.disastermap.controller;

import com.disastermap.dto.DisasterRequestDTO;
import com.disastermap.dto.DisasterResponseDTO;
import com.disastermap.dto.PageResponse;
import com.disastermap.service.DisasterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/disasters")
@CrossOrigin(originPatterns = "*")
public class DisasterController {

    private final DisasterService disasterService;

    public DisasterController(DisasterService disasterService) {
        this.disasterService = disasterService;
    }

    @GetMapping
    public ResponseEntity<PageResponse<DisasterResponseDTO>> getAllDisasters(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String severity,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "occurrenceDate") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {

        PageResponse<DisasterResponseDTO> response = disasterService.getDisasters(
            search, country, type, year, severity, page, size, sortBy, sortDir
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/map")
    public ResponseEntity<List<DisasterResponseDTO>> getMapMarkers(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String severity) {

        List<DisasterResponseDTO> markers = disasterService.getMapMarkers(
            search, country, type, year, severity
        );
        return ResponseEntity.ok(markers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisasterResponseDTO> getDisasterById(@PathVariable Long id) {
        DisasterResponseDTO response = disasterService.getDisasterById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DisasterResponseDTO> createDisaster(@Valid @RequestBody DisasterRequestDTO requestDTO) {
        DisasterResponseDTO created = disasterService.createDisaster(requestDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisasterResponseDTO> updateDisaster(
            @PathVariable Long id,
            @Valid @RequestBody DisasterRequestDTO requestDTO) {
        DisasterResponseDTO updated = disasterService.updateDisaster(id, requestDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDisaster(@PathVariable Long id) {
        disasterService.deleteDisaster(id);
        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "Disaster record successfully deleted");
        res.put("id", id);
        return ResponseEntity.ok(res);
    }
}

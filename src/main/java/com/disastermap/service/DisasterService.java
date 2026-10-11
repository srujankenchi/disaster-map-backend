package com.disastermap.service;

import com.disastermap.dto.DisasterRequestDTO;
import com.disastermap.dto.DisasterResponseDTO;
import com.disastermap.dto.PageResponse;

import java.util.List;

public interface DisasterService {

    PageResponse<DisasterResponseDTO> getDisasters(
        String search, String country, String type, Integer year, String severity,
        int page, int size, String sortBy, String sortDir
    );

    List<DisasterResponseDTO> getMapMarkers(
        String search, String country, String type, Integer year, String severity
    );

    DisasterResponseDTO getDisasterById(Long id);

    DisasterResponseDTO createDisaster(DisasterRequestDTO requestDTO);

    DisasterResponseDTO updateDisaster(Long id, DisasterRequestDTO requestDTO);

    void deleteDisaster(Long id);
}

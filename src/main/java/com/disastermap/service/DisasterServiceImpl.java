package com.disastermap.service;

import com.disastermap.dto.DisasterRequestDTO;
import com.disastermap.dto.DisasterResponseDTO;
import com.disastermap.dto.PageResponse;
import com.disastermap.entity.Disaster;
import com.disastermap.exception.ResourceNotFoundException;
import com.disastermap.repository.DisasterRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DisasterServiceImpl implements DisasterService {

    private final DisasterRepository disasterRepository;

    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of(
        "id", "disasterName", "disasterType", "country", "location",
        "occurrenceDate", "severity", "fatalities", "injuries",
        "affectedPopulation", "displacedPopulation", "economicDamage"
    );

    public DisasterServiceImpl(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }

    private Specification<Disaster> buildSpecification(String search, String country, String type, Integer year, String severity) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (search != null && !search.trim().isEmpty()) {
                String term = "%" + search.trim().toLowerCase() + "%";
                Predicate nameMatch = cb.like(cb.lower(root.get("disasterName")), term);
                Predicate countryMatch = cb.like(cb.lower(root.get("country")), term);
                Predicate locationMatch = cb.like(cb.lower(root.get("location")), term);
                predicates.add(cb.or(nameMatch, countryMatch, locationMatch));
            }

            if (country != null && !country.trim().isEmpty() && !country.equalsIgnoreCase("all")) {
                predicates.add(cb.equal(cb.lower(root.get("country")), country.trim().toLowerCase()));
            }

            if (type != null && !type.trim().isEmpty() && !type.equalsIgnoreCase("all")) {
                predicates.add(cb.equal(cb.lower(root.get("disasterType")), type.trim().toLowerCase()));
            }

            if (year != null && year > 0) {
                predicates.add(cb.equal(cb.function("year", Integer.class, root.get("occurrenceDate")), year));
            }

            if (severity != null && !severity.trim().isEmpty() && !severity.equalsIgnoreCase("all")) {
                predicates.add(cb.equal(cb.lower(root.get("severity")), severity.trim().toLowerCase()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Sort resolveSort(String sortBy, String sortDir) {
        String field = "occurrenceDate";
        if (sortBy != null && ALLOWED_SORT_FIELDS.contains(sortBy)) {
            field = sortBy;
        }
        Sort.Direction direction = "asc".equalsIgnoreCase(sortDir) ? Sort.Direction.ASC : Sort.Direction.DESC;
        return Sort.by(direction, field);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<DisasterResponseDTO> getDisasters(
            String search, String country, String type, Integer year, String severity,
            int page, int size, String sortBy, String sortDir) {

        int pageNum = Math.max(0, page);
        int pageSize = (size <= 0 || size > 200) ? 10 : size;
        Sort sort = resolveSort(sortBy, sortDir);
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

        Specification<Disaster> spec = buildSpecification(search, country, type, year, severity);
        Page<Disaster> disastersPage = disasterRepository.findAll(spec, pageable);

        List<DisasterResponseDTO> dtos = disastersPage.getContent()
            .stream()
            .map(DisasterResponseDTO::fromEntity)
            .collect(Collectors.toList());

        return new PageResponse<>(
            dtos,
            disastersPage.getNumber(),
            disastersPage.getSize(),
            disastersPage.getTotalElements(),
            disastersPage.getTotalPages(),
            disastersPage.isLast(),
            disastersPage.isFirst()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<DisasterResponseDTO> getMapMarkers(String search, String country, String type, Integer year, String severity) {
        Specification<Disaster> spec = buildSpecification(search, country, type, year, severity);
        Sort sort = Sort.by(Sort.Direction.DESC, "occurrenceDate");
        List<Disaster> list = disasterRepository.findAll(spec, sort);

        return list.stream()
            .map(DisasterResponseDTO::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DisasterResponseDTO getDisasterById(Long id) {
        Disaster disaster = disasterRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disaster record not found with id: " + id));
        return DisasterResponseDTO.fromEntity(disaster);
    }

    @Override
    @Transactional
    public DisasterResponseDTO createDisaster(DisasterRequestDTO requestDTO) {
        Disaster disaster = new Disaster();
        mapDtoToEntity(requestDTO, disaster);
        Disaster saved = disasterRepository.save(disaster);
        return DisasterResponseDTO.fromEntity(saved);
    }

    @Override
    @Transactional
    public DisasterResponseDTO updateDisaster(Long id, DisasterRequestDTO requestDTO) {
        Disaster disaster = disasterRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disaster record not found with id: " + id));

        mapDtoToEntity(requestDTO, disaster);
        Disaster updated = disasterRepository.save(disaster);
        return DisasterResponseDTO.fromEntity(updated);
    }

    @Override
    @Transactional
    public void deleteDisaster(Long id) {
        if (!disasterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Disaster record not found with id: " + id);
        }
        disasterRepository.deleteById(id);
    }

    private void mapDtoToEntity(DisasterRequestDTO dto, Disaster entity) {
        entity.setDisasterName(dto.getDisasterName().trim());
        entity.setDisasterType(dto.getDisasterType().trim());
        entity.setCountry(dto.getCountry().trim());
        entity.setLocation(dto.getLocation() != null ? dto.getLocation().trim() : null);
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setOccurrenceDate(dto.getOccurrenceDate());
        entity.setSeverity(dto.getSeverity() != null ? dto.getSeverity().trim() : null);
        entity.setDescription(dto.getDescription() != null ? dto.getDescription().trim() : null);
        entity.setFatalities(dto.getFatalities());
        entity.setInjuries(dto.getInjuries());
        entity.setAffectedPopulation(dto.getAffectedPopulation());
        entity.setDisplacedPopulation(dto.getDisplacedPopulation());
        entity.setEconomicDamage(dto.getEconomicDamage());
    }
}

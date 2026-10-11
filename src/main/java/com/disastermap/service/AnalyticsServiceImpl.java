package com.disastermap.service;

import com.disastermap.dto.*;
import com.disastermap.entity.Disaster;
import com.disastermap.repository.DisasterRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    private final DisasterRepository disasterRepository;

    public AnalyticsServiceImpl(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public DashboardSummaryDTO getDashboardSummary() {
        DashboardSummaryDTO summary = new DashboardSummaryDTO();

        long totalEvents = disasterRepository.count();
        Long totalFatalities = disasterRepository.sumTotalFatalities();
        Long totalInjuries = disasterRepository.sumTotalInjuries();
        Long totalAffected = disasterRepository.sumTotalAffectedPopulation();
        Long totalDisplaced = disasterRepository.sumTotalDisplacedPopulation();
        BigDecimal totalEconomic = disasterRepository.sumTotalEconomicDamage();

        summary.setTotalDisasterEvents(totalEvents);
        summary.setTotalFatalities(totalFatalities != null ? totalFatalities : 0L);
        summary.setTotalInjuries(totalInjuries != null ? totalInjuries : 0L);
        summary.setTotalAffectedPopulation(totalAffected != null ? totalAffected : 0L);
        summary.setTotalDisplacedPopulation(totalDisplaced != null ? totalDisplaced : 0L);
        summary.setTotalEconomicDamage(totalEconomic != null ? totalEconomic : BigDecimal.ZERO);

        // Top 10 affected countries
        List<CountryImpactDTO> topCountries = disasterRepository.findTopAffectedCountries(PageRequest.of(0, 10));
        summary.setTopAffectedCountries(topCountries);

        // Recent 5 disaster records
        List<Disaster> recent = disasterRepository.findRecentDisasters(PageRequest.of(0, 5));
        List<DisasterResponseDTO> recentDtos = recent.stream()
            .map(DisasterResponseDTO::fromEntity)
            .collect(Collectors.toList());
        summary.setRecentDisasters(recentDtos);

        return summary;
    }

    @Override
    @Transactional(readOnly = true)
    public List<YearStatisticDTO> getDisastersByYear() {
        return disasterRepository.countDisastersByYear();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeStatisticDTO> getDisastersByType() {
        return disasterRepository.countDisastersByType();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HumanImpactDTO> getHumanImpactByType() {
        return disasterRepository.aggregateHumanImpactByType();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountryStatisticDTO> getFatalitiesByCountry(int limit) {
        int max = (limit <= 0 || limit > 100) ? 10 : limit;
        return disasterRepository.aggregateFatalitiesByCountry(PageRequest.of(0, max));
    }

    @Override
    @Transactional(readOnly = true)
    public List<YearStatisticDTO> getAffectedPopulationByYear() {
        return disasterRepository.countDisastersByYear();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountryStatisticDTO> getEconomicDamageByCountry(int limit) {
        int max = (limit <= 0 || limit > 100) ? 10 : limit;
        return disasterRepository.aggregateEconomicDamageByCountry(PageRequest.of(0, max));
    }
}

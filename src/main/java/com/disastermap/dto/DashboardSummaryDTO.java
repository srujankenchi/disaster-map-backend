package com.disastermap.dto;

import java.math.BigDecimal;
import java.util.List;

public class DashboardSummaryDTO {

    private long totalDisasterEvents;
    private long totalFatalities;
    private long totalInjuries;
    private long totalAffectedPopulation;
    private long totalDisplacedPopulation;
    private BigDecimal totalEconomicDamage;
    private List<CountryImpactDTO> topAffectedCountries;
    private List<DisasterResponseDTO> recentDisasters;

    public DashboardSummaryDTO() {}

    public long getTotalDisasterEvents() {
        return totalDisasterEvents;
    }

    public void setTotalDisasterEvents(long totalDisasterEvents) {
        this.totalDisasterEvents = totalDisasterEvents;
    }

    public long getTotalFatalities() {
        return totalFatalities;
    }

    public void setTotalFatalities(long totalFatalities) {
        this.totalFatalities = totalFatalities;
    }

    public long getTotalInjuries() {
        return totalInjuries;
    }

    public void setTotalInjuries(long totalInjuries) {
        this.totalInjuries = totalInjuries;
    }

    public long getTotalAffectedPopulation() {
        return totalAffectedPopulation;
    }

    public void setTotalAffectedPopulation(long totalAffectedPopulation) {
        this.totalAffectedPopulation = totalAffectedPopulation;
    }

    public long getTotalDisplacedPopulation() {
        return totalDisplacedPopulation;
    }

    public void setTotalDisplacedPopulation(long totalDisplacedPopulation) {
        this.totalDisplacedPopulation = totalDisplacedPopulation;
    }

    public BigDecimal getTotalEconomicDamage() {
        return totalEconomicDamage;
    }

    public void setTotalEconomicDamage(BigDecimal totalEconomicDamage) {
        this.totalEconomicDamage = totalEconomicDamage;
    }

    public List<CountryImpactDTO> getTopAffectedCountries() {
        return topAffectedCountries;
    }

    public void setTopAffectedCountries(List<CountryImpactDTO> topAffectedCountries) {
        this.topAffectedCountries = topAffectedCountries;
    }

    public List<DisasterResponseDTO> getRecentDisasters() {
        return recentDisasters;
    }

    public void setRecentDisasters(List<DisasterResponseDTO> recentDisasters) {
        this.recentDisasters = recentDisasters;
    }
}

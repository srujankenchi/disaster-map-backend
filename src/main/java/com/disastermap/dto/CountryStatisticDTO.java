package com.disastermap.dto;

import java.math.BigDecimal;

public class CountryStatisticDTO {
    private String country;
    private Long count;
    private Long fatalities;
    private Long affectedPopulation;
    private BigDecimal economicDamage;

    public CountryStatisticDTO() {}

    public CountryStatisticDTO(String country, Long fatalities) {
        this.country = country;
        this.fatalities = fatalities != null ? fatalities : 0L;
    }

    public CountryStatisticDTO(String country, BigDecimal economicDamage) {
        this.country = country;
        this.economicDamage = economicDamage != null ? economicDamage : BigDecimal.ZERO;
    }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }

    public Long getFatalities() { return fatalities; }
    public void setFatalities(Long fatalities) { this.fatalities = fatalities; }

    public Long getAffectedPopulation() { return affectedPopulation; }
    public void setAffectedPopulation(Long affectedPopulation) { this.affectedPopulation = affectedPopulation; }

    public BigDecimal getEconomicDamage() { return economicDamage; }
    public void setEconomicDamage(BigDecimal economicDamage) { this.economicDamage = economicDamage; }
}

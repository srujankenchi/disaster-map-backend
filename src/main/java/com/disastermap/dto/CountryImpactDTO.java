package com.disastermap.dto;

public class CountryImpactDTO {
    private String country;
    private Long affectedPopulation;
    private Long disasterCount;

    public CountryImpactDTO() {}

    public CountryImpactDTO(String country, Long affectedPopulation, Long disasterCount) {
        this.country = country;
        this.affectedPopulation = affectedPopulation != null ? affectedPopulation : 0L;
        this.disasterCount = disasterCount != null ? disasterCount : 0L;
    }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Long getAffectedPopulation() { return affectedPopulation; }
    public void setAffectedPopulation(Long affectedPopulation) { this.affectedPopulation = affectedPopulation; }

    public Long getDisasterCount() { return disasterCount; }
    public void setDisasterCount(Long disasterCount) { this.disasterCount = disasterCount; }
}

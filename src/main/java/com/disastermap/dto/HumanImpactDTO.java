package com.disastermap.dto;

public class HumanImpactDTO {
    private String type;
    private long fatalities;
    private long injuries;
    private long affectedPopulation;
    private long displacedPopulation;

    public HumanImpactDTO() {}

    public HumanImpactDTO(String type, long fatalities, long injuries, long affectedPopulation, long displacedPopulation) {
        this.type = type;
        this.fatalities = fatalities;
        this.injuries = injuries;
        this.affectedPopulation = affectedPopulation;
        this.displacedPopulation = displacedPopulation;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public long getFatalities() { return fatalities; }
    public void setFatalities(long fatalities) { this.fatalities = fatalities; }

    public long getInjuries() { return injuries; }
    public void setInjuries(long injuries) { this.injuries = injuries; }

    public long getAffectedPopulation() { return affectedPopulation; }
    public void setAffectedPopulation(long affectedPopulation) { this.affectedPopulation = affectedPopulation; }

    public long getDisplacedPopulation() { return displacedPopulation; }
    public void setDisplacedPopulation(long displacedPopulation) { this.displacedPopulation = displacedPopulation; }
}

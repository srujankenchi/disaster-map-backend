package com.disastermap.dto;

import com.disastermap.entity.Disaster;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DisasterResponseDTO {

    private Long id;
    private String disasterName;
    private String disasterType;
    private String country;
    private String location;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDate occurrenceDate;
    private Integer occurrenceYear;
    private String severity;
    private String description;
    private Long fatalities;
    private Long injuries;
    private Long affectedPopulation;
    private Long displacedPopulation;
    private BigDecimal economicDamage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DisasterResponseDTO() {}

    public static DisasterResponseDTO fromEntity(Disaster d) {
        if (d == null) return null;
        DisasterResponseDTO dto = new DisasterResponseDTO();
        dto.setId(d.getId());
        dto.setDisasterName(d.getDisasterName());
        dto.setDisasterType(d.getDisasterType());
        dto.setCountry(d.getCountry());
        dto.setLocation(d.getLocation());
        dto.setLatitude(d.getLatitude());
        dto.setLongitude(d.getLongitude());
        dto.setOccurrenceDate(d.getOccurrenceDate());
        if (d.getOccurrenceDate() != null) {
            dto.setOccurrenceYear(d.getOccurrenceDate().getYear());
        }
        dto.setSeverity(d.getSeverity());
        dto.setDescription(d.getDescription());
        dto.setFatalities(d.getFatalities());
        dto.setInjuries(d.getInjuries());
        dto.setAffectedPopulation(d.getAffectedPopulation());
        dto.setDisplacedPopulation(d.getDisplacedPopulation());
        dto.setEconomicDamage(d.getEconomicDamage());
        dto.setCreatedAt(d.getCreatedAt());
        dto.setUpdatedAt(d.getUpdatedAt());
        return dto;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDisasterName() { return disasterName; }
    public void setDisasterName(String disasterName) { this.disasterName = disasterName; }

    public String getDisasterType() { return disasterType; }
    public void setDisasterType(String disasterType) { this.disasterType = disasterType; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public BigDecimal getLatitude() { return latitude; }
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }

    public BigDecimal getLongitude() { return longitude; }
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }

    public LocalDate getOccurrenceDate() { return occurrenceDate; }
    public void setOccurrenceDate(LocalDate occurrenceDate) { this.occurrenceDate = occurrenceDate; }

    public Integer getOccurrenceYear() { return occurrenceYear; }
    public void setOccurrenceYear(Integer occurrenceYear) { this.occurrenceYear = occurrenceYear; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getFatalities() { return fatalities; }
    public void setFatalities(Long fatalities) { this.fatalities = fatalities; }

    public Long getInjuries() { return injuries; }
    public void setInjuries(Long injuries) { this.injuries = injuries; }

    public Long getAffectedPopulation() { return affectedPopulation; }
    public void setAffectedPopulation(Long affectedPopulation) { this.affectedPopulation = affectedPopulation; }

    public Long getDisplacedPopulation() { return displacedPopulation; }
    public void setDisplacedPopulation(Long displacedPopulation) { this.displacedPopulation = displacedPopulation; }

    public BigDecimal getEconomicDamage() { return economicDamage; }
    public void setEconomicDamage(BigDecimal economicDamage) { this.economicDamage = economicDamage; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

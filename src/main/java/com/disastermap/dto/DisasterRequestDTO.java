package com.disastermap.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DisasterRequestDTO {

    @NotBlank(message = "Disaster name is required")
    @Size(max = 200, message = "Disaster name cannot exceed 200 characters")
    private String disasterName;

    @NotBlank(message = "Disaster type is required")
    @Size(max = 50, message = "Disaster type cannot exceed 50 characters")
    private String disasterType;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country cannot exceed 100 characters")
    private String country;

    @Size(max = 200, message = "Location cannot exceed 200 characters")
    private String location;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private BigDecimal latitude;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private BigDecimal longitude;

    @NotNull(message = "Occurrence date is required")
    private LocalDate occurrenceDate;

    @Size(max = 30, message = "Severity cannot exceed 30 characters")
    private String severity;

    private String description;

    @Min(value = 0, message = "Fatalities count cannot be negative")
    private Long fatalities = 0L;

    @Min(value = 0, message = "Injuries count cannot be negative")
    private Long injuries = 0L;

    @Min(value = 0, message = "Affected population cannot be negative")
    private Long affectedPopulation = 0L;

    @Min(value = 0, message = "Displaced population cannot be negative")
    private Long displacedPopulation = 0L;

    @DecimalMin(value = "0.00", message = "Economic damage cannot be negative")
    private BigDecimal economicDamage = BigDecimal.ZERO;

    public DisasterRequestDTO() {}

    // Getters and Setters
    public String getDisasterName() {
        return disasterName;
    }

    public void setDisasterName(String disasterName) {
        this.disasterName = disasterName;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public LocalDate getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(LocalDate occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFatalities() {
        return fatalities;
    }

    public void setFatalities(Long fatalities) {
        this.fatalities = fatalities != null ? fatalities : 0L;
    }

    public Long getInjuries() {
        return injuries;
    }

    public void setInjuries(Long injuries) {
        this.injuries = injuries != null ? injuries : 0L;
    }

    public Long getAffectedPopulation() {
        return affectedPopulation;
    }

    public void setAffectedPopulation(Long affectedPopulation) {
        this.affectedPopulation = affectedPopulation != null ? affectedPopulation : 0L;
    }

    public Long getDisplacedPopulation() {
        return displacedPopulation;
    }

    public void setDisplacedPopulation(Long displacedPopulation) {
        this.displacedPopulation = displacedPopulation != null ? displacedPopulation : 0L;
    }

    public BigDecimal getEconomicDamage() {
        return economicDamage;
    }

    public void setEconomicDamage(BigDecimal economicDamage) {
        this.economicDamage = economicDamage != null ? economicDamage : BigDecimal.ZERO;
    }
}

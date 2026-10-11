package com.disastermap.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "disasters", indexes = {
    @Index(name = "idx_disaster_country", columnList = "country"),
    @Index(name = "idx_disaster_type", columnList = "disaster_type"),
    @Index(name = "idx_disaster_date", columnList = "occurrence_date"),
    @Index(name = "idx_disaster_severity", columnList = "severity"),
    @Index(name = "idx_disaster_name", columnList = "disaster_name")
})
public class Disaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "disaster_name", nullable = false, length = 200)
    private String disasterName;

    @Column(name = "disaster_type", nullable = false, length = 50)
    private String disasterType;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "location", length = 200)
    private String location;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "occurrence_date", nullable = false)
    private LocalDate occurrenceDate;

    @Column(name = "severity", length = 30)
    private String severity;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "fatalities")
    private Long fatalities = 0L;

    @Column(name = "injuries")
    private Long injuries = 0L;

    @Column(name = "affected_population")
    private Long affectedPopulation = 0L;

    @Column(name = "displaced_population")
    private Long displacedPopulation = 0L;

    @Column(name = "economic_damage", precision = 18, scale = 2)
    private BigDecimal economicDamage = BigDecimal.ZERO;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Disaster() {
    }

    public Disaster(Long id, String disasterName, String disasterType, String country, String location,
                    BigDecimal latitude, BigDecimal longitude, LocalDate occurrenceDate, String severity,
                    String description, Long fatalities, Long injuries, Long affectedPopulation,
                    Long displacedPopulation, BigDecimal economicDamage) {
        this.id = id;
        this.disasterName = disasterName;
        this.disasterType = disasterType;
        this.country = country;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.occurrenceDate = occurrenceDate;
        this.severity = severity;
        this.description = description;
        this.fatalities = fatalities != null ? fatalities : 0L;
        this.injuries = injuries != null ? injuries : 0L;
        this.affectedPopulation = affectedPopulation != null ? affectedPopulation : 0L;
        this.displacedPopulation = displacedPopulation != null ? displacedPopulation : 0L;
        this.economicDamage = economicDamage != null ? economicDamage : BigDecimal.ZERO;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.fatalities == null) this.fatalities = 0L;
        if (this.injuries == null) this.injuries = 0L;
        if (this.affectedPopulation == null) this.affectedPopulation = 0L;
        if (this.displacedPopulation == null) this.displacedPopulation = 0L;
        if (this.economicDamage == null) this.economicDamage = BigDecimal.ZERO;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

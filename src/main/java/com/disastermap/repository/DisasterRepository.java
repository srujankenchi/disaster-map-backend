package com.disastermap.repository;

import com.disastermap.dto.CountryImpactDTO;
import com.disastermap.dto.CountryStatisticDTO;
import com.disastermap.dto.HumanImpactDTO;
import com.disastermap.dto.TypeStatisticDTO;
import com.disastermap.dto.YearStatisticDTO;
import com.disastermap.entity.Disaster;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DisasterRepository extends JpaRepository<Disaster, Long>, JpaSpecificationExecutor<Disaster> {

    @Query("SELECT coalesce(sum(d.fatalities), 0) FROM Disaster d")
    Long sumTotalFatalities();

    @Query("SELECT coalesce(sum(d.injuries), 0) FROM Disaster d")
    Long sumTotalInjuries();

    @Query("SELECT coalesce(sum(d.affectedPopulation), 0) FROM Disaster d")
    Long sumTotalAffectedPopulation();

    @Query("SELECT coalesce(sum(d.displacedPopulation), 0) FROM Disaster d")
    Long sumTotalDisplacedPopulation();

    @Query("SELECT coalesce(sum(d.economicDamage), 0.0) FROM Disaster d")
    BigDecimal sumTotalEconomicDamage();

    @Query("SELECT DISTINCT d.country FROM Disaster d WHERE d.country IS NOT NULL AND TRIM(d.country) != '' ORDER BY d.country ASC")
    List<String> findDistinctCountries();

    @Query("SELECT DISTINCT d.disasterType FROM Disaster d WHERE d.disasterType IS NOT NULL AND TRIM(d.disasterType) != '' ORDER BY d.disasterType ASC")
    List<String> findDistinctDisasterTypes();

    @Query("SELECT DISTINCT YEAR(d.occurrenceDate) FROM Disaster d WHERE d.occurrenceDate IS NOT NULL ORDER BY YEAR(d.occurrenceDate) DESC")
    List<Integer> findDistinctYears();

    @Query("SELECT DISTINCT d.severity FROM Disaster d WHERE d.severity IS NOT NULL AND TRIM(d.severity) != '' ORDER BY d.severity ASC")
    List<String> findDistinctSeverities();

    @Query("SELECT new com.disastermap.dto.CountryImpactDTO(d.country, coalesce(sum(d.affectedPopulation), 0), count(d)) " +
           "FROM Disaster d GROUP BY d.country ORDER BY sum(d.affectedPopulation) DESC")
    List<CountryImpactDTO> findTopAffectedCountries(Pageable pageable);

    @Query("SELECT d FROM Disaster d ORDER BY d.occurrenceDate DESC, d.id DESC")
    List<Disaster> findRecentDisasters(Pageable pageable);

    @Query("SELECT new com.disastermap.dto.YearStatisticDTO(YEAR(d.occurrenceDate), count(d), coalesce(sum(d.fatalities), 0), coalesce(sum(d.affectedPopulation), 0)) " +
           "FROM Disaster d WHERE d.occurrenceDate IS NOT NULL GROUP BY YEAR(d.occurrenceDate) ORDER BY YEAR(d.occurrenceDate) ASC")
    List<YearStatisticDTO> countDisastersByYear();

    @Query("SELECT new com.disastermap.dto.TypeStatisticDTO(d.disasterType, count(d)) " +
           "FROM Disaster d GROUP BY d.disasterType ORDER BY count(d) DESC")
    List<TypeStatisticDTO> countDisastersByType();

    @Query("SELECT new com.disastermap.dto.HumanImpactDTO(d.disasterType, coalesce(sum(d.fatalities), 0), coalesce(sum(d.injuries), 0), coalesce(sum(d.affectedPopulation), 0), coalesce(sum(d.displacedPopulation), 0)) " +
           "FROM Disaster d GROUP BY d.disasterType ORDER BY sum(d.affectedPopulation) DESC")
    List<HumanImpactDTO> aggregateHumanImpactByType();

    @Query("SELECT new com.disastermap.dto.CountryStatisticDTO(d.country, coalesce(sum(d.fatalities), 0)) " +
           "FROM Disaster d GROUP BY d.country ORDER BY sum(d.fatalities) DESC")
    List<CountryStatisticDTO> aggregateFatalitiesByCountry(Pageable pageable);

    @Query("SELECT new com.disastermap.dto.CountryStatisticDTO(d.country, coalesce(sum(d.economicDamage), 0.0)) " +
           "FROM Disaster d GROUP BY d.country ORDER BY sum(d.economicDamage) DESC")
    List<CountryStatisticDTO> aggregateEconomicDamageByCountry(Pageable pageable);
}

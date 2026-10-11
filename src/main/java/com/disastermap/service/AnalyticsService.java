package com.disastermap.service;

import com.disastermap.dto.*;

import java.util.List;

public interface AnalyticsService {

    DashboardSummaryDTO getDashboardSummary();

    List<YearStatisticDTO> getDisastersByYear();

    List<TypeStatisticDTO> getDisastersByType();

    List<HumanImpactDTO> getHumanImpactByType();

    List<CountryStatisticDTO> getFatalitiesByCountry(int limit);

    List<YearStatisticDTO> getAffectedPopulationByYear();

    List<CountryStatisticDTO> getEconomicDamageByCountry(int limit);
}

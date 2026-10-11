package com.disastermap.service;

import java.util.List;

public interface FilterService {
    List<String> getCountries();
    List<String> getDisasterTypes();
    List<Integer> getYears();
    List<String> getSeverities();
}

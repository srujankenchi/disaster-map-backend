package com.disastermap.service;

import com.disastermap.repository.DisasterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    private final DisasterRepository disasterRepository;

    public FilterServiceImpl(DisasterRepository disasterRepository) {
        this.disasterRepository = disasterRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getCountries() {
        return disasterRepository.findDistinctCountries();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getDisasterTypes() {
        return disasterRepository.findDistinctDisasterTypes();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getYears() {
        return disasterRepository.findDistinctYears();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getSeverities() {
        return disasterRepository.findDistinctSeverities();
    }
}

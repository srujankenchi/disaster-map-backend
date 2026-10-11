package com.disastermap.dto;

public class YearStatisticDTO {
    private int year;
    private long count;
    private long fatalities;
    private long affectedPopulation;

    public YearStatisticDTO() {}

    public YearStatisticDTO(int year, long count) {
        this.year = year;
        this.count = count;
    }

    public YearStatisticDTO(int year, long count, long fatalities, long affectedPopulation) {
        this.year = year;
        this.count = count;
        this.fatalities = fatalities;
        this.affectedPopulation = affectedPopulation;
    }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public long getCount() { return count; }
    public void setCount(long count) { this.count = count; }

    public long getFatalities() { return fatalities; }
    public void setFatalities(long fatalities) { this.fatalities = fatalities; }

    public long getAffectedPopulation() { return affectedPopulation; }
    public void setAffectedPopulation(long affectedPopulation) { this.affectedPopulation = affectedPopulation; }
}

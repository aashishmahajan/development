package com.example.demo.Model;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */

import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
public class FlightInformationDto {
    private String origin;
    private String currency;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<ResultFlightDto> getResults() {
        return results;
    }

    public void setResults(List<ResultFlightDto> results) {
        this.results = results;
    }

    private List<ResultFlightDto> results;
}

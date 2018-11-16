package com.example.demo.Model;

import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class LowFareFlightDto {

    private String currency;
    private List<ResultLowFareDto> results;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<ResultLowFareDto> getResults() {
        return results;
    }

    public void setResults(List<ResultLowFareDto> results) {
        this.results = results;
    }


}

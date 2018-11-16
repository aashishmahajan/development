package com.example.demo.Model;

import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class ResultLowFareDto {
    private List<ItinerariesDto> itineraries;

    public List<ItinerariesDto> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<ItinerariesDto> itineraries) {
        this.itineraries = itineraries;
    }
}

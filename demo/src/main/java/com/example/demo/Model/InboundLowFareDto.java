package com.example.demo.Model;

import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class InboundLowFareDto {
    private String duration;

    public List<FlightOptionsDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightOptionsDto> flights) {
        this.flights = flights;
    }

    private List<FlightOptionsDto> flights;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

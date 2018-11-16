package com.example.demo.Model;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class OutBoundLowFareDto {
    private String duration;
    private List<FlightOptionsDto> flights;
    public List<FlightOptionsDto> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightOptionsDto> flights) {
        this.flights = flights;
    }



    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

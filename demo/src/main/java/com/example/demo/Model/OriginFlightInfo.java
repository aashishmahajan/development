package com.example.demo.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OriginFlightInfo {
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    private String airport;
    private String terminal;
}

package com.example.demo.Model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DestinationFLightInfo {

    private String airport;
    private String terminal;

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

}

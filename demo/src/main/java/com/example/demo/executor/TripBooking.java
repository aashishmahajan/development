package com.example.demo.executor;

import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.Model.TripOptionDto;
import com.example.demo.restController.AmandeusSandboxImpl;
import com.example.demo.restController.AmandeusSandboxService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
@EnableAutoConfiguration
public class TripBooking {
    private static AmandeusSandboxImpl amandeusSandbox = new AmandeusSandboxImpl();
    public Map<String, FlightInformationDto> getMyFlightsNow(TripOptionDto  tripOptionDto) throws Exception {
        String baseUrl = "https://api.sandbox.amadeus.com/v1.2";
        Map<String, FlightInformationDto> flightInformationDtoMap =
                amandeusSandbox.processFlightFindRequest(
                        new FlightQueryDto(tripOptionDto.getOrginationCity(),
                            tripOptionDto.getDestinationCity(),
                            tripOptionDto.getStartDate(),
                            tripOptionDto.getReturnDate(),
                            tripOptionDto.getPrice()));
        return flightInformationDtoMap;
    }
}

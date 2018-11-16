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
import java.util.stream.Collectors;


@Component
@EnableAutoConfiguration
public class TripBooking {

    private static AmandeusSandboxImpl amandeusSandbox;
    public FlightFoundResultsDto  getMyFlightsNow(TripOptionDto  tripOptionDto) throws Exception {

        FlightInformationDto flightInformationDto = amandeusSandbox.processFlightFindRequest(new FlightQueryDto(tripOptionDto.getOrginationCity(), tripOptionDto.getDestinationCity(), tripOptionDto.getStartDate(), tripOptionDto.getReturnDate(), 0.0d));
        return null;

    }
}

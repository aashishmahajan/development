package com.example.demo.restController;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.Model.LowFareFlightDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/amandeus",method = RequestMethod.POST)
public interface AmandeusSandboxService {
    FlightInformationDto getFlightData(FlightQueryDto flightQueryDto) throws Exception;

    LowFareFlightDto getFlightDataLowFare(FlightQueryDto flightQueryDto) throws Exception;
}

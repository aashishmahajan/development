package com.example.demo.restController;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */

import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.FlightQueryDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(method = RequestMethod.GET)
public interface AmandeusSandboxService {
    FlightFoundResultsDto getFlightData(FlightQueryDto flightQueryDto);
}

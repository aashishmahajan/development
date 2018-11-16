package com.example.demo.restController;

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.Model.LowFareFlightDto;
import com.example.demo.executor.FlightDataProcessing;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */


@RestController
@Configuration
@Api(value ="getFlightdata", description = "get basic flight info for now")
public class AmandeusSandboxImpl implements AmandeusSandboxService{

    @Value("${amendus-sandbox-url}")
    private String url;

    private static final String BASE_URL = "https://api.sandbox.amadeus.com/v1.2";
    private FlightDataProcessing flightDataProcessing = new FlightDataProcessing();

    @Override
    @RequestMapping(method = RequestMethod.POST, path="/getRegular")
    public FlightInformationDto getFlightData(@RequestBody  FlightQueryDto flightQueryDto) throws Exception{

        if(flightQueryDto != null) {
            final String uri = BASE_URL + flightQueryDto.getSearchRegularFare();
            return  flightDataProcessing.getDataFromAmadeusForRegular(uri);
        }
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, path="/getLowFare")
    public LowFareFlightDto getFlightDataLowFare(@RequestBody FlightQueryDto flightQueryDto) throws Exception {
        if(flightQueryDto != null) {
            final String uri = BASE_URL + flightQueryDto.getSearchTypeLowFare();
            return  flightDataProcessing.getDataFromAmadeusForLowFare(uri);
        }
        return null;
    }

    public Map<String, Object> processFlightFindRequest(FlightQueryDto flightQueryDto) throws Exception{
        Map<String, Object>  flightMap = new HashMap<>();
        if(flightQueryDto != null) {
                flightMap = flightDataProcessing.getDedicateFlights(BASE_URL, flightQueryDto, flightMap);
                flightMap = flightDataProcessing.getLowFareFlights(BASE_URL, flightQueryDto, flightMap);
                return flightMap;
        }
        return null;
    }

}

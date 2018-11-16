package com.example.demo.executor;

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.Model.LowFareFlightDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@EnableAutoConfiguration
@Service
public class FlightDataProcessing {

    public Map<String, Object> getDedicateFlights(String baseurl, FlightQueryDto flightQueryDto, Map<String, Object> rslt) throws Exception{
        String uri = baseurl+ flightQueryDto.getSearchRegularFare();
        FlightInformationDto flightInformationDto = getDataFromAmadeusForRegular(uri);
        Object obj = convertInstanceOfObjectOfFlightInformation(flightInformationDto);
        rslt.put("regular",obj );
        return rslt;
    }

    public Map<String, Object>  getLowFareFlights (String baseurl, FlightQueryDto flightQueryDto, Map<String, Object> rslt) throws Exception{
        String uri = baseurl+ flightQueryDto.getSearchTypeLowFare();
        LowFareFlightDto lowFareFlightDto = getDataFromAmadeusForLowFare(uri);
        Object obj = convertInstanceOfObjectLowFare(lowFareFlightDto);
        rslt.put("lowfare",obj );
        return rslt;
    }

    public FlightInformationDto getDataFromAmadeusForRegular(String uri)throws Exception{
        FlightInformationDto flightInformationDto = null;
        String s = getDatafromAmadeus(uri);
        ObjectMapper objectMapper = new ObjectMapper();
        flightInformationDto = objectMapper.readValue(s, FlightInformationDto.class);
        return flightInformationDto;
    }

    public LowFareFlightDto getDataFromAmadeusForLowFare(String uri)throws Exception{
        LowFareFlightDto lowFareFlightDto= null;
        String sb = getDatafromAmadeus(uri);
        ObjectMapper objectMapper = new ObjectMapper();
        lowFareFlightDto = objectMapper.readValue(sb.toString(), LowFareFlightDto.class);
        return lowFareFlightDto;
    }

    private String getDatafromAmadeus(String uri) throws Exception{
        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        switch (status) {
            case 200:
            case 201:
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                return sb.toString();
        }
        return null;
    }

    public static <T> T convertInstanceOfObjectOfFlightInformation(FlightInformationDto flightInformationDto) {
        try {
            return (T) flightInformationDto;
        } catch (ClassCastException e) {
            return null;
        }
    }
    public static <T> T convertInstanceOfObjectLowFare(LowFareFlightDto lowFareFlightDto) {
        try {
            return (T) lowFareFlightDto;
        } catch (ClassCastException e) {
            return null;
        }
    }

}

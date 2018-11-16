package com.example.demo.executor;

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
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

    public Map<String, FlightInformationDto> getDedicateFlights(String baseurl, FlightQueryDto flightQueryDto, Map<String, FlightInformationDto> rslt) throws Exception{
        String uri = baseurl+ flightQueryDto.getSearchRegularFare();
        FlightInformationDto flightInformationDto = getDataFromAmadeus(uri);
        rslt.put("regular",flightInformationDto );
        return rslt;
    }

    public Map<String, FlightInformationDto>  getLowFareFlights (String baseurl, FlightQueryDto flightQueryDto, Map<String, FlightInformationDto> rslt) throws Exception{
        String uri = baseurl+ flightQueryDto.getSearchTypeLowFare();
        FlightInformationDto flightInformationDto = getDataFromAmadeus(uri);
        rslt.put("lowfare",flightInformationDto );
        return rslt;
    }

    private FlightInformationDto getDataFromAmadeus(String uri)throws Exception{
        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        FlightInformationDto flightInformationDto = null;

        switch (status) {
            case 200:
            case 201:
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                String s = sb.toString();
                ObjectMapper objectMapper = new ObjectMapper();
                flightInformationDto = objectMapper.readValue(s, FlightInformationDto.class);
                return flightInformationDto;
        }
        return new FlightInformationDto();
    }
}

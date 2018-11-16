package com.example.demo.restController;

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.executor.FlightDataProcessing;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */


@RestController
@Api(value ="getFlightdata", description = "get basic flight info for now")
public class AmandeusSandboxImpl implements AmandeusSandboxService{

    @Value("${amendus-sandbox-url}")
    private String url;
    List<FlightInformationDto> objectList = new ArrayList<>();
@Autowired
    private FlightDataProcessing flightDataProcessing;

    @Override
    @RequestMapping(method = RequestMethod.POST, path="/")
    public FlightInformationDto getFlightData(@RequestBody  FlightQueryDto flightQueryDto) throws Exception{

        if(flightQueryDto != null) {
            final String uri = url+ flightQueryDto.getSearchRegularFare();
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            FlightInformationDto flightInformationDto = null;

            switch (status) {
                case 200:
                    // no action
                case 201:
                    // process my data here
                    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    ObjectMapper objectMapper = new ObjectMapper();
                    flightInformationDto = objectMapper.readValue(sb.toString(), FlightInformationDto.class);
                    return flightInformationDto;
            }

        }
        return null;
    }

    public FlightInformationDto processFlightFindRequest(FlightQueryDto flightQueryDto) throws Exception{

        if(flightQueryDto != null) {
                return flightDataProcessing.getDedicateFlights(url, flightQueryDto);
        }
        return null;
    }

}

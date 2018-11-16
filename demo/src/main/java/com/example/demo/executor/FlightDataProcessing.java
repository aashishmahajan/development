package com.example.demo.executor;

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlightDataProcessing {

    public FlightInformationDto getDedicateFlights(String baseurl, FlightQueryDto flightQueryDto) throws Exception{
        String uri = baseurl+ flightQueryDto.getSearchRegularFare();
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

                System.out.println(sb.toString());
                String s = sb.toString();

                // flightInformationDto = new Gson().fromJson(s, FlightInformationDto.class);
                ObjectMapper objectMapper = new ObjectMapper();
                flightInformationDto = objectMapper.readValue(s, FlightInformationDto.class);

                return flightInformationDto;
        }
        return new FlightInformationDto();
    }
}

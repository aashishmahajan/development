package com.example.demo.restController;


import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.TripOptionDto;
import com.example.demo.executor.TripBooking;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@Configuration
@Api(value ="getFlight", description = "get basic flight info for now")
public class TripOptionServiceImpl implements TripOptionService{

    private TripBooking tripBooking = new TripBooking();

    @RequestMapping(method = RequestMethod.GET, path="/health")
    public String getHealth(){
        return "Service is active and working";
    }

    @ExceptionHandler
    void handleIllegalArgumentException(@SuppressWarnings("unused") IllegalArgumentException e, HttpServletResponse response) throws IOException
    {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @Override
    public Map<String, Object> getFlight(@RequestBody  TripOptionDto tripOptionDto) throws Exception {
        if(tripOptionDto == null) return null;
        return tripBooking.getMyFlightsNow(tripOptionDto);

    }
}

package com.example.demo.restController;


import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.TripOptionDto;
import com.example.demo.executor.TripBooking;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Api(value ="getFlight", description = "get basic flight info for now")
public class TripOptionServiceImpl implements TripOptionService{


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
    public FlightFoundResultsDto getFlight(@RequestBody  TripOptionDto tripOptionDto) {
        if(tripOptionDto == null) return null;
        return new FlightFoundResultsDto();
    }
}

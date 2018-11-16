package com.example.demo.restController;


import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.TripOptionDto;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(value="/tripAdvisor")
@Api
@Service
public interface TripOptionService {
    @RequestMapping( path = "/getflights", method = RequestMethod.GET)
    FlightFoundResultsDto getFlight(TripOptionDto tripOptionDto);
}

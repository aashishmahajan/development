package com.example.demo.restController;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */

import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.TripOptionDto;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@RequestMapping(value="/tripAdvisor")
@Api
@Service
public interface TripOptionService {
    @RequestMapping( path = "/getflights", method = RequestMethod.POST)
    Map<String, FlightInformationDto> getFlight(TripOptionDto tripOptionDto) throws Exception;
}

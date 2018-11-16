package com.example.demo.Model;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class FlightFoundResultsDto {
    private Map<String, FlightInformationDto> flights;
}

package com.example.demo.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TripOptionDto {
    private String orginationCity;
    private String destinationCity;
    private LocalDate startDate;
    private LocalDate returnDate;
    private Integer days;
}

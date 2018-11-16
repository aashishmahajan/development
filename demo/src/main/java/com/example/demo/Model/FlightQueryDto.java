package com.example.demo.Model;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class FlightQueryDto {
    private static String apikey ="fl6grJkCesn0wqBnbWOUKRSeuh1jrMzk";
    private static String searchTypeLowFare ="/flights/low-fare-search";
    private static String searchTypeRegularFare ="/flights/inspiration-search";
    private String origin;
    private String destination;
    private LocalDate departure_date;
    private LocalDate return_date;
    private Double price;

    public FlightQueryDto(String origin, String destination, LocalDate departure_date, LocalDate return_date, Double price) {
        this.origin =origin;
        this.destination = destination;
        this.departure_date = departure_date;
        this.return_date = return_date;
        this.price = price;
    }

    public String getSearchTypeLowFare() {
        if(origin == null || ("").equals(origin)){
            return null;
        }
        String url = searchTypeLowFare+"?apikey="+apikey+ "/"+"&origin="+origin;
        if(destination !=null ){
            url += "&destination="+destination;
        }
        if(departure_date !=null ){
            url += "&departure_date="+departure_date;
        }
        if(return_date !=null ){
            url += "&return_date="+return_date;
        }
        if(price > 0 ){
            url += "&price="+price;
        }
        return url;
    }
    public String getSearchRegularFare() {
        if(origin == null || ("").equals(origin)){
            return null;
        }
        String url =  searchTypeRegularFare+"?apikey="+apikey+"&origin="+origin;
        if(destination !=null ){
            url += "&destination="+destination;
        }
        if(departure_date !=null ){
            url += "&departure_date="+departure_date;
        }
        if(return_date !=null ){
            url += "&return_date="+return_date;
        }
        if(price > 0 ){
            url += "&price="+price;
        }
        return url;
    }
}


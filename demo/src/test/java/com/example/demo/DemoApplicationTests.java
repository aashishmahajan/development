package com.example.demo;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */
import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.Model.TripOptionDto;
import com.example.demo.restController.TripOptionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {

	@Test
	public void testGreen() {assertTrue(true);
	}

	@Test
	public void testTripLoadIfNoValueInObject() throws Exception{
		TripOptionDto tripOptionDto = null;
		TripOptionServiceImpl tripOptionService = new TripOptionServiceImpl();
		FlightFoundResultsDto flightFoundResultsDto = tripOptionService.getFlight(tripOptionDto);
		Assert.assertNull(flightFoundResultsDto);
	}


	@Test
	public void testFlightQueryUrl(){
		String origin= "NYC";
		String destination ="JFK";
		LocalDate departure_date = LocalDate.now();
		LocalDate return_date = LocalDate.parse("2018-12-18");
		Double price = 100.0d;
		FlightQueryDto flightQueryDto = new FlightQueryDto(origin, destination, departure_date, return_date, price);;
		System.out.println(flightQueryDto.toString());
		assertTrue(flightQueryDto.toString().equals("apikey=fl6grJkCesn0wqBnbWOUKRSeuh1jrMzk&origin=NYC&destination=JFK&departure_date=2018-11-16&return_date=2018-12-18&price=100.0"));
	}


}

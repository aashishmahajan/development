package com.example.demo;
/* @Author: Aashish Mahajan, DateCreated: 11/15/2018 */
import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.FlightInformationDto;
import com.example.demo.Model.FlightQueryDto;
import com.example.demo.Model.TripOptionDto;
import com.example.demo.restController.TripOptionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.Assert.assertEquals;
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
		Map<String, Object> flightFoundResultsDto= tripOptionService.getFlight(tripOptionDto);

		Assert.assertNull(flightFoundResultsDto);
	}


	@Test
	public void testFlightQueryUrl(){
		String origin= "NYC";
		String destination ="JFK";
		LocalDate departure_date = LocalDate.now();
		LocalDate return_date = LocalDate.parse("2018-12-18");
		Double price = 100.0d;
		FlightQueryDto flightQueryDto = new FlightQueryDto(origin, destination, departure_date, return_date, price);
		assertTrue(flightQueryDto.getSearchRegularFare().equals("/flights/inspiration-search?apikey=fl6grJkCesn0wqBnbWOUKRSeuh1jrMzk&origin=NYC&destination=JFK&departure_date=2018-11-16&return_date=2018-12-18&price=100.0"));
		assertTrue(flightQueryDto.getSearchTypeLowFare().equals("/flights/low-fare-search?apikey=fl6grJkCesn0wqBnbWOUKRSeuh1jrMzk&origin=NYC&destination=JFK&departure_date=2018-11-16&return_date=2018-12-18&price=100.0"));
	}

	@Test
	public void testHealthService(){
		TripOptionServiceImpl tripOptionService = new TripOptionServiceImpl();
		String healthResponse = tripOptionService.getHealth();
		Assert.assertNotNull(healthResponse.toString());
		String response = "Service is active and working";
		assertEquals(healthResponse, healthResponse);
	}


}

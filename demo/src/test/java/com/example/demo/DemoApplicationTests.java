package com.example.demo;

import com.example.demo.Model.FlightFoundResultsDto;
import com.example.demo.Model.TripOptionDto;
import com.example.demo.restController.TripOptionService;
import com.example.demo.restController.TripOptionServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


}

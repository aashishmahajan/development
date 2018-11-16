package com.example.demo.restController;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Health check that service is reachable
 */
@Configuration
@RestController
@RequestMapping(value="/health-check")
@Api(value="health check", description="validates if the controller is found")
public class StatusController
{


    @RequestMapping(method = RequestMethod.GET)
    public String getStatus()
    {
        return "Here i am";
    }
}
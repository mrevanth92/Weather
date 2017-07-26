package io.egen.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.beans.Weather;
import io.egen.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/weather")
@CrossOrigin(origins = "http://mocker.egen.io")
@Api(tags="Weather")
public class WeatherController {
	

	private final WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value="Insert Weather Information" ,notes = "Inserts weather information and persists data for future use." ,code = 200)
	@ApiResponses(value = {@ApiResponse(code = 200,message="Success"),
			@ApiResponse(code = 500,message="Bad Request")})
	public void insert(@RequestBody Weather weather){
		service.insert(weather);
	}
	
}

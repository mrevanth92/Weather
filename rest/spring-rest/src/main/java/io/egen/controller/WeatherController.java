package io.egen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.beans.Weather;
import io.egen.service.WeatherService;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
	
	@Autowired
	WeatherService service;

	@RequestMapping(method = RequestMethod.POST)
	public Weather insert(@RequestBody Weather weather){
		return service.insert(weather);
	}
	
	
}

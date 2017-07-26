package io.egen.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.beans.Weather;
import io.egen.service.WeatherService;

@RestController
@RequestMapping(value = "/weather")
@CrossOrigin(origins = "http://mocker.egen.io")
public class WeatherController {
	

	private final WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void insert(@RequestBody Weather weather){
		service.insert(weather);
	}
	
}

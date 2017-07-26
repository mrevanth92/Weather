package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.beans.Average;
import io.egen.beans.City;
import io.egen.beans.Property;
import io.egen.beans.Weather;
import io.egen.service.CityService;
import io.egen.service.WeatherService;
import io.egen.service.impl.CityServiceImpl;

@RestController
@RequestMapping(value = "/city")
public class CityContoller {
	
	
	private final CityService cityService;
	private final WeatherService weatherService;
	
	public CityContoller(CityService cityService,WeatherService weatherService) {
		this.cityService = cityService;
		this.weatherService = weatherService;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public List<City> getAll(){
		return cityService.getAll();
	}
	
	@RequestMapping(value = "/{city}",method = RequestMethod.GET)
	public Weather getWeather(@PathVariable("city") String city){
		return weatherService.getWeather(city);
	}
	
	@RequestMapping(value = "/{city}/{property}",method = RequestMethod.GET, produces = "application/json")
	public Property getproperty(@PathVariable("property") String property ,@PathVariable("city") String city){
		return weatherService.getproperty(property, city);
	}
	
	@RequestMapping(value = "/hourly/{city}",method = RequestMethod.GET)
	public List<Average> gethourly(@PathVariable("city") String city){
		return weatherService.gethourly(city);
	}
	
	@RequestMapping(value = "/daily/{city}",method = RequestMethod.GET)
	public List<Average> getDaily(@PathVariable("city") String city){
		return weatherService.getDaily(city);
	}
}

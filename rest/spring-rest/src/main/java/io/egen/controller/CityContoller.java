package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.beans.City;
import io.egen.beans.Weather;
import io.egen.service.CityService;
import io.egen.service.impl.CityServiceImpl;

@RestController
@RequestMapping(value = "/city")
public class CityContoller {
	
	
	private final CityService service;
	
	public CityContoller(CityService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<City> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value = "/{city}",method = RequestMethod.GET)
	public Weather getWeather(@PathVariable("city") String city){
		return service.getWeather(city);
	}
	
	@RequestMapping(value = "/{city}/{property}",method = RequestMethod.GET)
	public Weather getproperty(@PathVariable("property") String property ,@PathVariable("city") String city){
		return service.getproperty(property, city);
	}
	
	@RequestMapping(value = "/hourly/{city}",method = RequestMethod.GET)
	public void gethourly(@PathVariable("city") String city){
		service.gethourly(city);
	}
	
	@RequestMapping(value = "/daily/{city}",method = RequestMethod.GET)
	public void getDaily(@PathVariable("city") String city){
		service.getDaily(city);
	}
}

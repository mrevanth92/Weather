package io.egen.controller;

import java.util.List;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/city")
@Api(tags = "City")
public class CityContoller {
	
	
	private final CityService cityService;
	private final WeatherService weatherService;
	
	public CityContoller(CityService cityService,WeatherService weatherService) {
		this.cityService = cityService;
		this.weatherService = weatherService;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Find all cities" ,notes = "Returns all the cities present in database" ,code = 200)
	@ApiResponses(value = {@ApiResponse(code = 200,message="Success"),
			@ApiResponse(code = 404,message="Data not found")})
	public List<City> getAll(){
		return cityService.getAll();
	}
	
	@RequestMapping(value = "/{city}",method = RequestMethod.GET)
	@ApiOperation(value="Weather Information" ,notes = "Get latest Weather information of particular city" ,code = 200)
	@ApiResponses(value = {@ApiResponse(code = 200,message="Success"),
			@ApiResponse(code = 404,message="Data not found")})
	public Weather getWeather(@PathVariable("city") String city){
		return weatherService.getWeather(city);
	}
	
	@RequestMapping(value = "/{city}/{property}",method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value="Particular weather property" ,notes = "Get latest Weather Report information of particular city" ,code = 200)
	@ApiResponses(value = {@ApiResponse(code = 200,message="Success"),
			@ApiResponse(code = 404,message="Data not found")})
	public Property getproperty(@PathVariable("property") String property ,@PathVariable("city") String city){
		return weatherService.getproperty(property, city);
	}
	
	@RequestMapping(value = "/hourly/{city}",method = RequestMethod.GET)
	@ApiOperation(value="Hourly Weather Report" ,notes = "Get Hourly Weather Report of particular city" ,code = 200)
	@ApiResponses(value = {@ApiResponse(code = 200,message="Success"),
			@ApiResponse(code = 404,message="Data not found")})
	public List<Average> gethourly(@PathVariable("city") String city){
		return weatherService.gethourly(city);
	}
	
	@RequestMapping(value = "/daily/{city}",method = RequestMethod.GET)
	@ApiOperation(value="Daily Weather Report" ,notes = "Get Daily Weather Report of particular city" ,code = 200)
	@ApiResponses(value = {@ApiResponse(code = 200,message="Success"),
			@ApiResponse(code = 404,message="Data not found")})
	public List<Average> getDaily(@PathVariable("city") String city){
		return weatherService.getDaily(city);
	}
}

package io.egen.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egen.beans.Weather;
import io.egen.beans.Wind;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
	
	@RequestMapping(method = RequestMethod.GET)
	public Weather getAll(){
		return new Weather("fuck", "", 0, 0, new Wind(1, 1), new Timestamp(0));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Weather insert(Weather weather){
		return weather;
	}
}

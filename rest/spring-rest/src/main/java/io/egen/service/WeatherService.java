package io.egen.service;

import org.springframework.stereotype.Service;

import io.egen.beans.Weather;

@Service
public class WeatherService {
	
	public Weather insert(Weather weather){
		return weather;
	}
}

package io.egen.service.impl;

import org.springframework.stereotype.Service;

import io.egen.beans.City;
import io.egen.beans.Weather;
import io.egen.dao.WeatherDao;
import io.egen.service.CityService;
import io.egen.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	private final WeatherDao dao;
	private final CityService cityService;

	public WeatherServiceImpl(WeatherDao dao, CityService cityService) {
		this.dao = dao;
		this.cityService = cityService;
	}

	public void insert(Weather weather) {
		City city = cityService.getByCity(weather.getCity().getCity());
		if (city == null) {
			city = cityService.insert(weather.getCity());
		}
		weather.setCity(city);
		dao.insert(weather);
	}
}

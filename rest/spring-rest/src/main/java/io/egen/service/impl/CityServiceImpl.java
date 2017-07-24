package io.egen.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.beans.City;
import io.egen.beans.Weather;
import io.egen.dao.CityDao;
import io.egen.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	
	private final CityDao dao;
	
	public CityServiceImpl(CityDao dao){
		this.dao = dao;
	}
	
	public List<City> getAll(){
		return null;
	}

	public Weather getWeather(String city){
		return null;
	}

	public Weather getproperty(String property ,String city){
		return null;
	}

	public void gethourly(String city){
		
	}

	public void getDaily(String city){
		
	}
	
	public City getByCity(String city) {
		return dao.getByCity(city);
	}

	@Override
	public City insert(City city) {
		return dao.insert(city);
		
	}
}

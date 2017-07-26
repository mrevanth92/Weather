package io.egen.service;

import java.util.List;

import io.egen.beans.City;
import io.egen.beans.Weather;

public interface CityService {

	List<City> getAll();

	City getByCity(String city);
	
	City insert(City city);
}

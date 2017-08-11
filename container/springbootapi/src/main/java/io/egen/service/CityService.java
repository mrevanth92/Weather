package io.egen.service;

import java.util.List;

import io.egen.beans.City;

public interface CityService {

	List<City> getAll();

	City getByCity(String city);
	
	City insert(City city);
}

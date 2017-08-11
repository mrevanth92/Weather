package io.egen.dao;

import java.util.List;

import io.egen.beans.City;

public interface CityDao {
	
	List<City> getAll();

	City getByCity(String city);
	
	City insert(City city);

}

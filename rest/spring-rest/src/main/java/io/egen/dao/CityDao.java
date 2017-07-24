package io.egen.dao;

import java.util.List;

import io.egen.beans.City;
import io.egen.beans.Weather;

public interface CityDao {
	
	List<City> getAll();

	City getByCity(String city);
	
	City insert(City city);

	Weather getWeather(String city);

	Weather getproperty(String property, String city);

	void gethourly(String city);

	void getDaily(String city);

}

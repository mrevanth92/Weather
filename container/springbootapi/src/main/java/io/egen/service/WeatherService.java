package io.egen.service;

import java.util.List;

import io.egen.beans.Average;
import io.egen.beans.Property;
import io.egen.beans.Weather;

public interface WeatherService {

	void insert(Weather weather);
	
	Weather getWeather(String city);

	Property getproperty(String property, String city);
	
	List<Average> gethourly(String city);

	List<Average> getDaily(String city);
}

package io.egen.dao;

import java.util.List;

import io.egen.beans.Weather;

public interface WeatherDao {

	void insert(Weather weather);

	Weather getWeather(String city);

	List<Object[]> gethourly(String city);

	List<Object[]> getDaily(String city);
}

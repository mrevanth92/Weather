package io.egen.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.egen.beans.Average;
import io.egen.beans.City;
import io.egen.beans.Property;
import io.egen.beans.Weather;
import io.egen.beans.Wind;
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

	public Weather getWeather(String city) {
		Weather weather =  dao.getWeather(city);
		if(weather != null){
			return weather;
		}
		return null;
	}

	public Property getproperty(String property, String city) {
		Weather weather = dao.getWeather(city);
		if(weather != null){
			ObjectMapper mapper = new ObjectMapper();
			Map<String,Object> map = mapper.convertValue(weather, Map.class);
			return new Property(property, map.get(property));
		}		
		return null;
	}

	@Override
	public List<Average> gethourly(String city) {
		List<Object[]> list = dao.gethourly(city);
		List<Average> avgList = new ArrayList<>(list.size());
		for (Object[] avgValue : list) {
			avgList.add(new Average((String) avgValue[0], (String)avgValue[6],
					new Weather(city, null, (Double) avgValue[1], (Double) avgValue[2], (Double) avgValue[3],
							new Wind((Double) avgValue[4], (Double) avgValue[5]), null)));
		}
		return avgList;
	}

	@Override
	public List<Average> getDaily(String city) {
		List<Object[]> list = dao.getDaily(city);
		List<Average> avgList = new ArrayList<>(list.size());
		for (Object[] avgValue : list) {
			avgList.add(new Average((String) avgValue[0], null,
					new Weather(city, null, (Double) avgValue[1], (Double) avgValue[2], (Double) avgValue[3],
							new Wind((Double) avgValue[4], (Double) avgValue[5]), null)));
		}
		return avgList;
	}
}

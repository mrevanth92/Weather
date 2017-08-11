package io.egen.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.egen.Exception.BadRequest;
import io.egen.Exception.NotFoundException;
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

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void insert(Weather weather) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		if(weather.getTimestamp().after(timestamp)){
			throw new BadRequest("Weather information is not reported correctly");
		}
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
		throw new NotFoundException("Weather report for city not available");
	}

	public Property getproperty(String property, String city) {
		Weather weather = dao.getWeather(city);
		if(weather != null){
			ObjectMapper mapper = new ObjectMapper();
			Map<String,Object> map = mapper.convertValue(weather, Map.class);
			return new Property(property, map.get(property));
		}		
		throw new NotFoundException("Weather report for city not available");
	}

	@Override
	public List<Average> gethourly(String city) {
		List<Object[]> list = dao.gethourly(city);
		List<Average> avgList = new ArrayList<>(list.size());
		if(list == null || list.size() == 0){
			throw new NotFoundException("Hourly weather report for city not available");
		}
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
		if(list == null || list.size() == 0){
			throw new NotFoundException("Daily weather report for city not available");
		}
		List<Average> avgList = new ArrayList<>(list.size());
		for (Object[] avgValue : list) {
			avgList.add(new Average((String) avgValue[0], null,
					new Weather(city, null, (Double) avgValue[1], (Double) avgValue[2], (Double) avgValue[3],
							new Wind((Double) avgValue[4], (Double) avgValue[5]), null)));
		}
		return avgList;
	}
}

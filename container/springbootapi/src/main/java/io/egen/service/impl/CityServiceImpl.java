package io.egen.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.Exception.NotFoundException;
import io.egen.beans.City;
import io.egen.dao.CityDao;
import io.egen.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	private final CityDao dao;

	public CityServiceImpl(CityDao dao) {
		this.dao = dao;
	}

	public List<City> getAll() {
		List<City> list = dao.getAll();
		if(list == null || list.size() == 0){
			throw new NotFoundException("No weather information available.Please try again later");
		}
		return list;
	}

	public City getByCity(String city) {
		return dao.getByCity(city);
	}

	@Override
	public City insert(City city) {
		return dao.insert(city);

	}
}

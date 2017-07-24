package io.egen.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.beans.Weather;
import io.egen.dao.WeatherDao;

@Repository
@Transactional
public class WeatherDaoImpl implements WeatherDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Weather weather){
		entityManager.persist(weather);
	}
}

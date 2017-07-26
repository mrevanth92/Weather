package io.egen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.beans.Average;
import io.egen.beans.Weather;
import io.egen.beans.Wind;
import io.egen.dao.WeatherDao;

@Repository
@Transactional
public class WeatherDaoImpl implements WeatherDao {
	
	private final static String GET_DAILY = "SELECT w.date,avg(w.humidity),avg(w.pressure),avg(temperature),avg(w.wind.speed),avg(w.wind.degree) from Weather w where w.city.city=? group by w.date";
	private final static String GET_HOURLY = "SELECT w.date,avg(w.humidity),avg(w.pressure),avg(temperature),avg(w.wind.speed),avg(w.wind.degree),hour from Weather w where w.city.city=? group by w.date,w.hour";

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void insert(Weather weather) {
		entityManager.persist(weather);
	}

	@Override
	public Weather getWeather(String city) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		Query query = createQuery("Weather.getWeather");
		query.setParameter(1, city);
		query.setMaxResults(1);
		List<Weather> weatherList = query.getResultList();
		if (weatherList != null && weatherList.size() != 0) {
			return weatherList.get(0);
		}
		return null;
	}

	@Override
	public List<Object[]>  gethourly(String city) {
		Query query = entityManager.createQuery(GET_HOURLY);
		query.setParameter(1, city);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> getDaily(String city) {
		Query query = entityManager.createQuery(GET_DAILY);
		query.setParameter(1, city);
		List<Object[]> list = query.getResultList();
		return list;
	}

	private Query createQuery(String namedQuery) {
		return entityManager.createNamedQuery(namedQuery, Weather.class);
	}

}

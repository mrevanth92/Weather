package io.egen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.sql.Select;
import org.springframework.stereotype.Repository;

import io.egen.beans.City;
import io.egen.beans.Weather;
import io.egen.dao.CityDao;

@Repository
@Transactional
public class CityDaoImpl implements CityDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public City getByCity(String city){
		Query query = entityManager.createNamedQuery("City.findByCity",City.class);
		query.setParameter(1, city);
		List<City> list = query.getResultList();
		if(list != null && list.size() !=0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weather getWeather(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weather getproperty(String property, String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gethourly(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getDaily(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public City insert(City city) {
		entityManager.persist(city);
		return city;
	}
}

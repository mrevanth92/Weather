package io.egen.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.beans.City;
import io.egen.dao.CityDao;

@Repository
@Transactional
public class CityDaoImpl implements CityDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public City getByCity(String city) {
		Query query = entityManager.createNamedQuery("City.findByCity", City.class);
		query.setParameter(1, city);
		List<City> list = query.getResultList();
		if (list != null && list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<City> getAll() {
		Query query = entityManager.createNamedQuery("City.findAll", City.class);
		List<City> list = query.getResultList();
		return list;
	}

	

	@Override
	public City insert(City city) {
		entityManager.persist(city);
		return city;
	}
}

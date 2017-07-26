package io.egen.beans;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
@NamedQueries({ @NamedQuery(name = "City.findByCity", query = "select c from City as c where c.city = ?"),
		@NamedQuery(name = "City.findAll", query = "select distinct c from City as c") })
public class City {
	@Id
	@Column(name = "id")
	@JsonIgnore
	private String id;
	@Column(name = "city", unique = true)
	private String city;

	public City() {

	}

	public City(String city) {
		super();
		this.id = UUID.randomUUID().toString();
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public String getCity() {
		return city;
	}
}

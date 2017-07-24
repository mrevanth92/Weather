package io.egen.beans;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@NamedQueries({ @NamedQuery(name = "City.findByCity", query = "select c from City as c where c.city = ?") })
public class City {
	@Id
	@Column(name = "id")
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

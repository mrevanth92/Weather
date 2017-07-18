package io.egen.beans;

import java.util.UUID;

public class City {
	
	public final String id;
	public final String city;
	
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

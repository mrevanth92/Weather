package io.egen.beans;

import java.sql.Timestamp;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
	private final String id;
	private final City city;
	private final String description;
	private final Integer humidity;
	private final Integer pressure;
	private final Integer temperature;
	private final Wind wind;
	private final Timestamp timestamp;

	@JsonCreator
	public Weather(@JsonProperty("city") String city, @JsonProperty("description") String description,
			@JsonProperty("humidity") Integer humidity, @JsonProperty("pressure") Integer pressure,@JsonProperty("temperature") Integer temperature, @JsonProperty("wind") Wind wind,
			@JsonProperty("timestamp") Timestamp timestamp) {
		super();
		this.id = UUID.randomUUID().toString();
		this.city = new City(city);
		this.description = description;
		this.humidity = humidity;
		this.pressure = pressure;
		this.temperature = temperature;
		this.wind = wind;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public String getCity() {
		return city.getCity();
	}

	public String getDescription() {
		return description;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public Integer getPressure() {
		return pressure;
	}
	
	public Integer getTemperature(){
		return temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public String getTimestamp() {
		return timestamp.toString();
	}

}

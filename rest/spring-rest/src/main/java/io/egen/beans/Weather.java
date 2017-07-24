package io.egen.beans;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "weather")
public class Weather {
	@Id
	@Column(name = "id")
	private final String id;
	@ManyToOne
	private City city;
	@Column(name = "description")
	private final String description;
	@Column(name = "humidity")
	private final Integer humidity;
	@Column(name = "pressure")
	private final Integer pressure;
	@Column(name = "temperature")
	private final Integer temperature;
	@OneToOne(cascade = {CascadeType.ALL})
	private final Wind wind;
	@Column(name = "timestamp")
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

	public City getCity() {
		return city;
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
	
	public void setCity(City city){
		this.city = city;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp="
				+ timestamp + "]";
	}
	
	

}

package io.egen.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "weather")
@JsonInclude(Include.NON_DEFAULT)
@NamedQueries({ @NamedQuery(name = "Weather.getHourly", query = "SELECT w from Weather w"),
		@NamedQuery(name = "Weather.getWeather", query = "select w from Weather w where w.city.city=? order by timestamp desc") })
public class Weather {
	private final static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat hourFormatter = new SimpleDateFormat("HH");
	@Id
	@Column(name = "id")
	@JsonIgnore
	private String id;
	@ManyToOne
	private City city;
	@Column(name = "description")
	private String description;
	@Column(name = "humidity")
	private Double humidity;
	@Column(name = "pressure")
	private Double pressure;
	@Column(name = "temperature")
	private Double temperature;
	@OneToOne(cascade = { CascadeType.ALL })
	private Wind wind;
	@Column(name = "timestamp")
	private Timestamp timestamp;
	@JsonIgnore
	@Column(name = "date")
	private String date;
	@JsonIgnore
	@Column(name = "hour")
	private String hour;

	public Weather() {

	}

	@JsonCreator
	public Weather(@JsonProperty("city") String city, @JsonProperty("description") String description,
			@JsonProperty("humidity") Double humidity, @JsonProperty("pressure") Double pressure,
			@JsonProperty("temperature") Double temperature, @JsonProperty("wind") Wind wind,
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
		if(timestamp != null){
			this.date = dateFormatter.format(timestamp);
			this.hour = hourFormatter.format(timestamp);
		}
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

	public Double getHumidity() {
		return humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public Double getTemperature() {
		return temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public Timestamp getTimestamp() {
		if(timestamp != null){
			return timestamp;
		}
		return null;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public String getHour() {
		return hour;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", description=" + description + ", humidity=" + humidity
				+ ", pressure=" + pressure + ", temperature=" + temperature + ", wind=" + wind + ", timestamp="
				+ timestamp + "]";
	}

}

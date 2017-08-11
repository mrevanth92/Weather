package io.egen.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Average {
	private final String date;
	private final String hour;
	private final Weather weather;

	public Average(String date,String hour,Weather weather){
		this.date = date;
		this.hour = hour;
		this.weather = weather;
	}

	public String getDate() {
		return date;
	}

	public String getHour() {
		return hour;
	}

	public Weather getWeather() {
		return weather;
	}
	
	
}

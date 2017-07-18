package io.egen.beans;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
	
	private final String id;
	private final Double speed;
	private final Integer degree;
	
	@JsonCreator
	public Wind(@JsonProperty("speed") Double speed,@JsonProperty("degree") Integer degree) {
		super();
		this.id = UUID.randomUUID().toString();
		this.speed = speed;
		this.degree = degree;
	}
	
	public Double getSpeed(){
		return this.speed;
	}
	
	public Integer getDegree(){
		return this.degree;
	}
	
	public String getId(){
		return this.id;
	}
}

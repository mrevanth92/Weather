package io.egen.beans;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "wind")
public class Wind {
	@Id
	@Column(name = "id")
	private final String id;
	@Column(name = "speed")
	private final Double speed;
	@Column(name = "degree")
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

package io.egen.beans;

public class Property {
	
	public String property;
	
	public Object value;
	
	public Property(String property,Object value){
		this.property = property;
		this.value = value;
	}
	
	public String getProperty(){
		return this.property;
	}
	
	public Object getValue(){
		return value;
	}
}

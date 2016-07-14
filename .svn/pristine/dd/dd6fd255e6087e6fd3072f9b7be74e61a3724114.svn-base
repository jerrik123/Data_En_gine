package com.mangocity.de.mbr.util.mongo;

public class Order {
	private String name;
	private String type;
	
	
	
	private Order(String name,String type){
		this.name=name;
		this.type=type;
	} 
	
	public static Order asc(String name){
		return new Order("asc",name);
	}
	
	public static Order desc(String name){
		return new Order("desc",name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

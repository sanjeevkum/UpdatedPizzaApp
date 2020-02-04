package com.springmvc.pizzaapplication.model;

public class Pizza {
	private Integer id;
	private String name;
	private String receipe;
	private String size;
	private String cost;
	private String type;

	public Pizza() {
		
	}
	
	public Pizza(Integer id, String name, String receipe, String size, String cost, String type) {
		super();
		this.id = id;
		this.name = name;
		this.receipe = receipe;
		this.size = size;
		this.cost = cost;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReceipe() {
		return receipe;
	}

	public void setReceipe(String receipe) {
		this.receipe = receipe;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

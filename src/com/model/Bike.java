package com.model;

import javax.persistence.Embeddable;

@Embeddable
public class Bike {
	
	private String model;
	private String company;
	
	public Bike(){
		
	}
	
	public Bike(String model, String company){
		this.model = model;
		this.company = company;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}

package com.model;

import javax.persistence.Embeddable;

@Embeddable
public class Car {

	private String model;
	private String company;
	
	public Car(){

	}
	
	public Car(String model, String company){
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

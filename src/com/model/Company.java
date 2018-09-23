package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="inc-gen")
	private int companyId;
	private String comapanyName;
	
	@ManyToOne
	private UserDetails userDetails;
	
	public Company(){
		
	}
	
	public Company(int companyId, String companyName){
		this.companyId = companyId;
		this.comapanyName = companyName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getComapanyName() {
		return comapanyName;
	}

	public void setComapanyName(String comapanyName) {
		this.comapanyName = comapanyName;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	

}

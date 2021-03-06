package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inc-gen")
	private int userId;

	private String userName;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "home_street_name")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state_name")),
			@AttributeOverride(name = "zip", column = @Column(name = "home_zip_name")),
			@AttributeOverride(name = "country", column = @Column(name = "home_country_name")), })
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "office_street_name")),
			@AttributeOverride(name = "city", column = @Column(name = "office_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "office_state_name")),
			@AttributeOverride(name = "zip", column = @Column(name = "office_zip_name")),
			@AttributeOverride(name = "country", column = @Column(name = "office_country_name")), })
	private Address officeAddress;

	@ElementCollection
	private Set<Car> cars = new HashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Bike", joinColumns = @JoinColumn(name = "userId"))
	@GenericGenerator(name = "inc-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "bike_id") }, generator = "inc-gen", type = @Type(type = "long"))
	private Collection<Bike> bikes = new ArrayList<Bike>();

	@OneToOne
	private Vehicle vehicle;

	@OneToMany
	@JoinTable(name="user_company",joinColumns=@JoinColumn(name="userId"),
				inverseJoinColumns=@JoinColumn(name="companyId")
	)
	private Collection<Company> company = new ArrayList<Company>();
	
	@ManyToMany
	private Collection<Book> books = new ArrayList<Book>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	public Collection<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(Collection<Bike> bikes) {
		this.bikes = bikes;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Collection<Company> getCompany() {
		return company;
	}

	public void setCompany(Collection<Company> company) {
		this.company = company;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	

}

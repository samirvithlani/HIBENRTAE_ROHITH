package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue
	private int countryId;
	private String countryName;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "country_city", joinColumns = { @JoinColumn(name = "countryId") }, inverseJoinColumns = {
			@JoinColumn(name = "cityId") })
	private List<City> cities;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}

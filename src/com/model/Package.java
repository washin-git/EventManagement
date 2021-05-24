package com.model;

import java.util.Date;

public class Package {
	
	private int id;
	private String packageName;
	private double packagePrice;
	private String description;
	private double pricePerPerson;
	
	public Package(String packageName, double packagePrice, String description, double pricePerPerson) {
		super();
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.description = description;
		this.pricePerPerson = pricePerPerson;
		
		
	}

	public Package(int id, String packageName, double packagePrice, String description, double pricePerPerson) {
		super();
		this.id = id;
		this.packageName = packageName;
		this.packagePrice = packagePrice;
		this.description = description;
		this.pricePerPerson = pricePerPerson;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public double getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPricePerPerson() {
		return pricePerPerson;
	}

	public void setPricePerPerson(double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", packageName=" + packageName + ", packagePrice=" + packagePrice
				+ ", description=" + description + ", pricePerPerson=" + pricePerPerson + "]";
	}

	
	
}




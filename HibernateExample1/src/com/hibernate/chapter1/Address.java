package com.hibernate.chapter1;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	/**
	 * Value of streetNumber
	 */
	private String streetNumber;
	/**
	 * Value of streetName
	 */
	private String streetName;
	/**
	 * Value of apartmentName
	 */
	private String apartmentName;
	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}
	/**
	 * @param streetNumber the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}
	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	/**
	 * @return the apartmentName
	 */
	public String getApartmentName() {
		return apartmentName;
	}
	/**
	 * @param apartmentName the apartmentName to set
	 */
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	
	
}

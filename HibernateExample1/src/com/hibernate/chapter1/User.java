package com.hibernate.chapter1;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class User {

	/**
	 * Value of userId
	 */
	private int userId;
	
	/**
	 * Value of userName
	 */
	private String userName;

	/**
	 * Value of userAddress
	 */
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	/**
	 * @return the userId
	 */
	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the listOfAddress
	 */
	@ElementCollection
	@JoinTable(name="USER_ADDRESS_MAPPING", joinColumns=@JoinColumn(name="USER_ID_FK"))
	
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="hilo-gen", type=@Type(type="long"))
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	/**
	 * @param listOfAddress the listOfAddress to set
	 */
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
	
}

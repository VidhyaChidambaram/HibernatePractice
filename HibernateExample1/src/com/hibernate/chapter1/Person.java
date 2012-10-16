package com.hibernate.chapter1;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Person {

	private String personName;
	private int personId;
	private PersonDetail personDetail;
	/**
	 * @return the personDetail
	 */
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="pdetail_fk")
	public PersonDetail getPersonDetail() {
		return personDetail;
	}
	/**
	 * @param personDetail the personDetail to set
	 */
	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return the personId
	 */
	@Id
	@GeneratedValue
	public int getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	
}

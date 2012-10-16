package com.hibernate.chapter1;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@SelectBeforeUpdate(value=true)
@NamedQuery(name="College.byId", query="from College where collegeName = :collegeName")
@NamedNativeQuery(name="College.byName", query="select * from TESTSCHEMA.College where collegeId>7", resultClass=College.class)
public class College {

	private int collegeId;
	private String collegeName;
	private List<Student> collegeStudents;
	/**
	 * @return the collegeId
	 */
	@Id
	@GeneratedValue
	public int getCollegeId() {
		return collegeId;
	}
	/**
	 * @param collegeId the collegeId to set
	 */
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	/**
	 * @return the collegeStudents
	 */
	@OneToMany(targetEntity=Student.class, mappedBy="college", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Student> getCollegeStudents() {
		return collegeStudents;
	}
	/**
	 * @param collegeStudents the collegeStudents to set
	 */
	public void setCollegeStudents(List<Student> collegeStudents) {
		this.collegeStudents = collegeStudents;
	}
	
}

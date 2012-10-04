package com.hibernate.chapter1;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class School {

	/**
	 * Value of schoolName
	 */
	private String schoolName;
	/**
	 * Value of schoolId
	 */
	private int schoolId;
	/**
	 * Value of schoolDetail
	 */
	private SchoolDetail publicSchoolDetail;
	
	private SchoolDetail privateSchoolDetail;

	/**
	 * @return the schoolName
	 */
	@Column(name="SCH_NAME")
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the schoolId
	 */
	@Id
	@TableGenerator(name="SCH_ID", pkColumnName="SCH_PRIM_ID", pkColumnValue="SCH_PRIM_VALUE", table="SCHOOL_ID_PRIM_KEY")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SCH_ID")
	public int getSchoolId() {
		return schoolId;
	}

	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	/**
	 * @return the publicSchoolDetail
	 */
	@Embedded
	@AttributeOverrides({
				@AttributeOverride(name="schoolAddress", column=@Column(name="PUBLIC_SCHOOL_ADDRESS")),
				@AttributeOverride(name="schoolYear", column=@Column(name="PUBLIC_SCHOOL_YEAR")),
				@AttributeOverride(name="studentCount", column=@Column(name="PUBLIC_SCHOOL_STUDENT_COUNT")),
				@AttributeOverride(name="publicSchool", column=@Column(name="PUBLIC_SCHOOL")),
				@AttributeOverride(name="schoolDetailId", column=@Column(name="SCHOOL_DETAIL_ID"))
			})
	public SchoolDetail getPublicSchoolDetail() {
		return publicSchoolDetail;
	}

	/**
	 * @param publicSchoolDetail the publicSchoolDetail to set
	 */
	public void setPublicSchoolDetail(SchoolDetail publicSchoolDetail) {
		this.publicSchoolDetail = publicSchoolDetail;
	}

	/**
	 * @return the privateSchoolDetail
	 */
	@Embedded
	public SchoolDetail getPrivateSchoolDetail() {
		return privateSchoolDetail;
	}

	/**
	 * @param privateSchoolDetail the privateSchoolDetail to set
	 */
	public void setPrivateSchoolDetail(SchoolDetail privateSchoolDetail) {
		this.privateSchoolDetail = privateSchoolDetail;
	}
}

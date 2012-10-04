package com.hibernate.chapter1;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SchoolDetail {

	/**
	 * Value of schoolAddress
	 */
	private String schoolAddress;
	/**
	 * Value of schoolYear
	 */
	private String schoolYear;
	/**
	 * Value of studentCount
	 */
	private String studentCount;
	/**
	 * Value of isPublic
	 */
	private boolean publicSchool;
	/**
	 * @return the schoolAddress
	 */
	@Column(name="SCHOOL_ADDRESS")
	public String getSchoolAddress() {
		return schoolAddress;
	}
	/**
	 * @param schoolAddress the schoolAddress to set
	 */
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	/**
	 * @return the schoolYear
	 */
	@Column(name="SCHOOL_YEAR")
	public String getSchoolYear() {
		return schoolYear;
	}
	/**
	 * @param schoolYear the schoolYear to set
	 */
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	/**
	 * @return the studentCount
	 */
	@Column(name="STUDENT_COUNT")
	public String getStudentCount() {
		return studentCount;
	}
	/**
	 * @param studentCount the studentCount to set
	 */
	public void setStudentCount(String studentCount) {
		this.studentCount = studentCount;
	}
	/**
	 * @param isPublic the isPublic to set
	 */
	public void setPublicSchool(boolean publicSchool) {
		this.publicSchool = publicSchool;
	}
	/**
	 * @return the isPublic
	 */
	@Column(name="IS_PUBLIC_SCHOOL")
	public boolean isPublicSchool() {
		return publicSchool;
	}
	
}

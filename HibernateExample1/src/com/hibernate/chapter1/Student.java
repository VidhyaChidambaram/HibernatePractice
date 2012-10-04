package com.hibernate.chapter1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	private int studentId;
	private String studentName;
	private College college;
	/**
	 * @return the studentId
	 */
	@Id
	@GeneratedValue
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the college
	 */
	@ManyToOne
	@JoinColumn(name="college_Id")
	public College getCollege() {
		return college;
	}
	/**
	 * @param college the college to set
	 */
	public void setCollege(College college) {
		this.college = college;
	}
	
	
}

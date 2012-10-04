/**
 * 
 */
package com.hibernate.chapter1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * @author mouli
 *
 */
@Entity
@Table(name="EMP_INFO")
public class Employee {

	/**
	 * employeeName
	 */
	private String employeeName;
	/**
	 * employeeId
	 */
	private int employeeId;
	/**
	 * employeePassword
	 */
	private String employeePassword;
	/**
	 * isPermanent
	 */
	private boolean isPermanent;
	/**
	 * employeeEmail
	 */
	private String employeeEmail;
	/**
	 * employeeJoinDate
	 */
	private Calendar employeeJoinDate;
	/**
	 * employeeLoginTime
	 */
	private Date employeeLoginTime;
	
	/**
	 * @return the employeeName
	 */
	@Column(name="EMP_NAME")
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeId - ID annotation to denote primary Key
	 */
	@Id 
	@TableGenerator(name="EMP_ID", table="EMP_PRIM_KEY_TABLE", pkColumnName="EMP_KEY", pkColumnValue="EMP_VALUE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="EMP_ID")
	@Column(name="EMP_ID")
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeePassword
	 */
	@Transient
	public String getEmployeePassword() {
		return employeePassword;
	}

	/**
	 * @param employeePassword the employeePassword to set
	 */
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	/**
	 * @return the isPermanent
	 */
	@Basic
	public boolean isPermanent() {
		return isPermanent;
	}

	/**
	 * @param isPermanent the isPermanent to set
	 */
	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	/**
	 * @return the employeeEmail
	 */
	@Column(name="EMP_EMAIL", nullable=false)
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	/**
	 * @param employeeEmail the employeeEmail to set
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	/**
	 * @return the employeeJoinDate
	 */
	@Column(name="EMP_JOIN_DT")
	@Temporal(TemporalType.DATE)
	public Calendar getEmployeeJoinDate() {
		return employeeJoinDate;
	}

	/**
	 * @param employeeJoinDate the employeeJoinDate to set
	 */
	public void setEmployeeJoinDate(Calendar employeeJoinDate) {
		this.employeeJoinDate = employeeJoinDate;
	}

	/**
	 * @return the employeeLoginTime
	 */
	@Column(name="EMP_LOGIN_TMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmployeeLoginTime() {
		return employeeLoginTime;
	}

	/**
	 * @param employeeLoginTime the employeeLoginTime to set
	 */
	public void setEmployeeLoginTime(Date employeeLoginTime) {
		this.employeeLoginTime = employeeLoginTime;
	}
	
}

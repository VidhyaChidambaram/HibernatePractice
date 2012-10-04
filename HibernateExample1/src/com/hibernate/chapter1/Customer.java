package com.hibernate.chapter1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Customer")
@SecondaryTable(name="CUSTOMER_DETAIL")
public class Customer {

	/**
	 * customerId
	 */
	private int customerId;
	/**
	 * customerName
	 */
	private String customerName;
	/**
	 * customerAddress
	 */
	private String customerAddress;
	/**
	 * creditScore
	 */
	private int creditScore;
	/**
	 * rewardPoints
	 */
	private int rewardPoints;
	/**
	 * @return the customerId
	 */
	@Id
	@TableGenerator(name="CUST_ID", table="CUST_PRIM_KEY", pkColumnName="CUST_KEY", pkColumnValue="CUST_VALUE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="CUST_ID")
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	@Column(name="CUST_NAME", table="CUSTOMER_DETAIL")
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerAddress
	 */
	@Column(name="CUST_ADD", table="CUSTOMER_DETAIL")
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	/**
	 * @return the creditScore
	 */
	@Column(name="CUST_CRDT_SCR")
	public int getCreditScore() {
		return creditScore;
	}
	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	/**
	 * @return the rewardPoints
	 */
	@Column(name="CUST_RWRD_PT")
	public int getRewardPoints() {
		return rewardPoints;
	}
	/**
	 * @param rewardPoints the rewardPoints to set
	 */
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}

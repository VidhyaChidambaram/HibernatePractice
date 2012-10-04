package com.hibernate.chapter1;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {

	/**
	 * Value of accountName
	 */
	private String accountName;
	
	/**
	 * Value of compoundKey
	 */
	private CompoundKey compoundKey;

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the compoundKey
	 */
	@Id
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}

	/**
	 * @param compoundKey the compoundKey to set
	 */
	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}
	
	
}

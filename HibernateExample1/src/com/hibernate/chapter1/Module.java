package com.hibernate.chapter1;

import javax.persistence.Entity;

@Entity
public class Module extends Project{

	/**
	 * Value of moduleId
	 */
	private int moduleId;
	/**
	 * Value of moduleName
	 */
	private String moduleName;
	/**
	 * @return the moduleId
	 */
	public int getModuleId() {
		return moduleId;
	}
	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}

package com.hibernate.chapter1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project {

	/**
	 * Value of projectName
	 */
	private String projectName;
	/**
	 * Value of projectId
	 */
	private int projectId;
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getProjectId() {
		return projectId;
	}
	
}

package com.hibernate.chapter1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Delegate {

	private int delegateId;
	private String delegateName;
	private List<Event> events;
	/**
	 * @return the delegateId
	 */
	@Id
	@GeneratedValue
	public int getDelegateId() {
		return delegateId;
	}
	/**
	 * @param delegateId the delegateId to set
	 */
	public void setDelegateId(int delegateId) {
		this.delegateId = delegateId;
	}
	/**
	 * @return the delegateName
	 */
	public String getDelegateName() {
		return delegateName;
	}
	/**
	 * @param delegateName the delegateName to set
	 */
	public void setDelegateName(String delegateName) {
		this.delegateName = delegateName;
	}
	/**
	 * @return the event
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="JOIN_DELEGATE_EVENT", 
		joinColumns={@JoinColumn(name="delegateId")}, 
		inverseJoinColumns={@JoinColumn(name="eventId")} )
	public List<Event> getEvents() {
		if(this.events == null) {
			this.events = new ArrayList<Event>();
			return events;
		}
		return events;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}

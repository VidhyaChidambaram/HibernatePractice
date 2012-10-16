package com.hibernate.chapter1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Event {

	private int eventId;
	private String eventName;
	private List<Delegate> delegates;
	/**
	 * @return the eventId
	 */
	@Id
	@GeneratedValue
	public int getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/**
	 * @return the delegates
	 */
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="JOIN_DELEGATE_EVENT", 
				joinColumns={@JoinColumn(name="eventId")}, 
				inverseJoinColumns={@JoinColumn(name="delegateId")})
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<Delegate> getDelegates() {
		if(this.delegates == null) {
			this.delegates = new ArrayList<Delegate>();
			return this.delegates;
		}
		return delegates;
	}
	/**
	 * @param delegates the delegates to set
	 */
	public void setDelegates(List<Delegate> delegates) {
		this.delegates = delegates;
	}
	
}

package com.miguelbarrios.cfbapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Conference
 *
 */
@Entity
public class Conference {
	
	@Id
	private String name;
	
	public Conference() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Conference [name=" + name + "]";
	}
}

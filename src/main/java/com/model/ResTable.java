package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TABLE")
public class ResTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "AVAILABLE")
	private boolean isAvailable;

	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;

	public ResTable() {
	}

	public ResTable(long id, boolean isAvailable, Restaurant restaurant) {
		this.id = id;
		this.isAvailable = isAvailable;
		this.restaurant = restaurant;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", isAvailable=" + isAvailable + ", restaurant=" + restaurant + "]";
	}

	
}

package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RESTAURANT_TABLES")
public class ResTable {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "AVAILABLE")
	private boolean isAvailable;

	@OneToMany(mappedBy = "resTable", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<Reservation> reservation;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
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

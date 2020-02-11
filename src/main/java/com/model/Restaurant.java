package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private long name;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private List<RestaurantTable> tables;

	public Restaurant() {
	}

	public Restaurant(long id, long name, List<RestaurantTable> tables) {
		this.id = id;
		this.name = name;
		this.tables = tables;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getName() {
		return name;
	}

	public void setName(long name) {
		this.name = name;
	}

	public List<RestaurantTable> getSeats() {
		return tables;
	}

	public void setSeats(List<RestaurantTable> seats) {
		this.tables = seats;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", seats=" + tables + "]";
	}

}

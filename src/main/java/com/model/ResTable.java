package com.model;

import java.util.List;

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

	@Column(name = "NUMBER_OF_CHAIRS")
	private int chairs_num;

	@OneToMany(mappedBy = "resTable", cascade = CascadeType.REMOVE)
	private List<Reservation> reservations;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;

	public ResTable() {
	}

	public ResTable(long id, int chairs_num, List<Reservation> reservations, Restaurant restaurant) {
		this.id = id;
		this.chairs_num = chairs_num;
		this.reservations = reservations;
		this.restaurant = restaurant;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getChairs_num() {
		return chairs_num;
	}

	public void setChairs_num(int chairs_num) {
		this.chairs_num = chairs_num;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "ResTable [id=" + id + ", chairs_num=" + chairs_num + ", reservations=" + reservations + ", restaurant="
				+ restaurant + "]";
	}

}

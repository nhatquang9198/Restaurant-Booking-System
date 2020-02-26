package com.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reservations")
public class Reservation {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "APPROVED", columnDefinition = "boolean default false")
	private boolean isApproved;	

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLE_ID", nullable = false)
	private ResTable resTable;

	public Reservation() {
		System.out.println();
	}

	public Reservation(Long id, LocalDate date, boolean isApproved, Restaurant restaurant, ResTable resTable) {
		this.id = id;
		this.date = date;
		this.isApproved = isApproved;
		this.restaurant = restaurant;
		this.resTable = resTable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public ResTable getResTable() {
		return resTable;
	}

	public void setResTable(ResTable resTable) {
		this.resTable = resTable;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", isApproved=" + isApproved + ", restaurant=" + restaurant
				+ ", resTable=" + resTable + "]";
	}

}

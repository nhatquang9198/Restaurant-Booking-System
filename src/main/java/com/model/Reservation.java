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
@Table(name = "RESERVATIONS")
public class Reservation {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DATE")
	private LocalDate date;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TABLE_ID", nullable = false)
	private ResTable resTable;

	public Reservation() {
	}

	public Reservation(Long id, LocalDate date, ResTable resTable) {
		this.id = id;
		this.date = date;
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

	public ResTable getResTable() {
		return resTable;
	}

	public void setResTable(ResTable resTable) {
		this.resTable = resTable;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", resTable=" + resTable + "]";
	}

}

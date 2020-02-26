package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "restaurants")
@JsonIgnoreProperties(value = { "tables", "reservations" })
public class Restaurant {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
	private List<ResTable> tables;

	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
	private List<ResTable> reservations;

	public Restaurant() {
	}

	public Restaurant(long id, String name, List<ResTable> tables) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResTable> getTables() {
		return tables;
	}

	public void setTables(List<ResTable> tables) {
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", tables=" + tables + "]";
	}

}

package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACCOUNT_TYPE")
	private String type;

	public Account() {
	}

	public Account(long id, String username, String password, String type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type + "]";
	}

}

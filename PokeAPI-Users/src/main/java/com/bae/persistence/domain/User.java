package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long accountID;
	private String name;
	private String number;
	private String search;
	
	public User(Long accountID, String name, String number, String search) {
		super();
		this.accountID = accountID;
		this.name = name;
		this.number = number;
		this.search = search;
	}
	
	public User() {
		super();
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}


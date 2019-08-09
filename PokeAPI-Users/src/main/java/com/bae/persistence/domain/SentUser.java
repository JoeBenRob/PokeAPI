package com.bae.persistence.domain;

public class SentUser {
	
	private String name;
	private String number;
	private String search;
	
	public SentUser(User user) {
        this.name = user.getName();
        this.number = user.getNumber();
        this.search = user.getSearch();
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public SentUser() {
		super();
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
	
}

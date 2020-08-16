package com.test.dbservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quotes", catalog="test")
public class Quotes {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="quote")
	private String quote;
	
	public Quotes() {
		super();
	}

	public Quotes(String userName, String quote) {
		super();
		this.userName = userName;
		this.quote = quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
}

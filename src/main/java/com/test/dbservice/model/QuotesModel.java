package com.test.dbservice.model;

import java.util.List;

public class QuotesModel {

	private String userName;
	private List<String> quotes;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	
}

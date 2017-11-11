package com.form3.model;

public enum TYPE{
	Credit("Credit"),
	Debit("Debit");
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	private TYPE(){}
	private TYPE(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}

package com.form3.model;

public enum SCHEME_TYPE{
	ImmediatePayment("ImmediatePayment");
	
	private String name;
	
	private SCHEME_TYPE(){}
	private SCHEME_TYPE(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

}

package com.form3.model;

public enum SCHEME_SUBTYPE{
	InternetBanking("InternetBanking");
	
	private String name;
	
	private SCHEME_SUBTYPE(){}
	private SCHEME_SUBTYPE(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
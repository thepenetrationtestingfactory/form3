package com.form3.model;

public enum SCHEME{
	FPS("FPS");
	
	private String name;
	private SCHEME(){}
	private SCHEME(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
}

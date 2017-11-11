package com.form3.model;

public class ResponseDTO<T> {

	private String error;
	private T data;
	
	public ResponseDTO(){}
	public ResponseDTO(String error, T data) {
		super();
		this.error = error;
		this.data = data;
	}
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}

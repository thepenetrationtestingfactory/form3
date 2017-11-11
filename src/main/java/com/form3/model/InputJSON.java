package com.form3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputJSON {
	
	private List<Payment> data = new ArrayList<Payment>();
	private Map<String, String>	links = new HashMap<String, String>();
	
	public InputJSON(List<Payment> data, Map<String, String> links) {
		super();
		this.data = data;
		this.links = links;
	}
	
	public List<Payment> getData() {
		return data;
	}
	public void setData(List<Payment> data) {
		this.data = data;
	}
	public Map<String, String> getLinks() {
		return links;
	}
	public void setLinks(Map<String, String> links) {
		this.links = links;
	}
	
	
}

package com.form3.model;

import org.dizitart.no2.objects.Id;



public class Payment {

	@Id
    private String id;
	
	private String type;
	private Integer version;
	private String organisation_id;
	private Attributes attributes;
	
	public Payment(){}
	
	public Payment(String type, String id, Integer version, String organisation_id, Attributes attributes) {
		super();
		this.type = type;
		this.id = id;
		this.version = version;
		this.organisation_id = organisation_id;
		this.attributes = attributes;
	}
	
	public Payment(String type, String organisation_id, Attributes attributes) {
		super();
		this.type = type;
		this.organisation_id = organisation_id;
		this.attributes = attributes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getOrganisation_id() {
		return organisation_id;
	}

	public void setOrganisation_id(String organisation_id) {
		this.organisation_id = organisation_id;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	
	

}

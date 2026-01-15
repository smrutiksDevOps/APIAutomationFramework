package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("_id")
    private String id;

    private String firstName;
    private String lastName;
    private String email;

    @JsonProperty("__v")
    private int version;
    
    public User() {
    	
    }
	public User(String id, String firstName, String lastName, String email, int version) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}

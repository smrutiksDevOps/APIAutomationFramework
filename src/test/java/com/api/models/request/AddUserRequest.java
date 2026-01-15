package com.api.models.request;

public class AddUserRequest {
	private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    public AddUserRequest() {
    	
    }
	public AddUserRequest(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
	//Builder design pattern (Inner class)
	public static class Builder{
		private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
	    
	    public Builder firstName(String firstName) {
	    	this.firstName=firstName;
	    	return this;
	    }
	    public Builder lastName(String lastName) {
	    	this.lastName=lastName;
	    	return this;
	    }
	    public Builder email(String email) {
	    	this.email=email;
	    	return this;
	    }
	    public Builder password(String password) {
	    	this.password=password;
	    	return this;
	    }
	    public AddUserRequest build() {
			AddUserRequest addUserRequest = new AddUserRequest(firstName, lastName, email, password);
			return addUserRequest;
		}
	}
}

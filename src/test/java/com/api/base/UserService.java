package com.api.base;

import com.api.models.request.AddUserRequest;
import com.api.models.request.LoginRequest;

import io.restassured.response.Response;
//This is wrapper class for User service
public class UserService extends BaseService{
	
	private static final String BASE_PATH = "users/";
	
	public Response Login(LoginRequest payload) {
		return PostRequest(payload, BASE_PATH +"login");
	}
	
	public Response AddUser(AddUserRequest payload) {
		return PostRequest(payload, BASE_PATH);
	}
	
	public Response GetUserProfile(String Token) {
		SetAuthToken(Token);
		return GetRequest(BASE_PATH + "me");
	}

}
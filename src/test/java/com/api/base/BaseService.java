package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	//Responsible handling base uri, 
	//for creating the requests
	//It acts as wrapper class for Rest assured for this framework
	
	private static final String BASE_URL= "https://thinking-tester-contact-list.herokuapp.com/";
	private RequestSpecification requestSpecification;
	
	static{
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	public void SetAuthToken(String Token) {
		requestSpecification.header("Authorization", "Bearer" + Token);
	}
	
	protected Response PostRequest(Object payLoad, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
	}
	
	protected Response GetRequest(String endPoint) {
		return requestSpecification.post(endPoint);
	}
}

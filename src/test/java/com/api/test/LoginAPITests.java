package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginRespons;

import io.restassured.response.Response;


public class LoginAPITests {
	
	@Test(description="Verify if login api is working!!!")
	public void LoginTest()
	{
		LoginRequest loginRequest = new LoginRequest("smruti1234", "smruti1234");
		AuthService authService = new AuthService();
		
		Response res = authService.Login(loginRequest);
		// Deserialization
		LoginRespons loginResponse = res.as(LoginRespons.class);
		
		System.out.println(res.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUsername());
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getUsername(), "smruti1234");	
	}
}

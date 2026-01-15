package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginRespons;

import io.restassured.response.Response;

public class GetUserProfileTest {
	
	@Test(description="Verify if get user profile api is working!!!")
	public void GetUserProfileTest()
	{
		LoginRequest loginRequest = new LoginRequest("sahusmrutikanta@gmail.com", "Smruti1234");
		UserService userService = new UserService();
		
		Response res = userService.Login(loginRequest);
		// Deserialization
		LoginRespons loginResponse = res.as(LoginRespons.class);
		
		//System.out.println(res.asPrettyString());
		System.out.println(loginResponse.getToken());
		
		Response userProfileResponse = userService.GetUserProfile(loginResponse.getToken());
		System.out.println(userProfileResponse.asPrettyString());
		Assert.assertEquals(userProfileResponse.getStatusCode(), 200);
		// Here app is not giving any json format response so we did not go for any de-serialization
	}

}

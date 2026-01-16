package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginRespons;
import io.restassured.response.Response;


@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITests {
	
	@Test(description="Verify if login api is working!!!")
	public void LoginTest()
	{
		LoginRequest loginRequest = new LoginRequest("sahusmrutikanta@gmail.com", "Smruti1234");
		UserService userService = new UserService();
		
		Response res = userService.Login(loginRequest);
		//De-serialization
		LoginRespons loginResponse = res.as(LoginRespons.class);
		
		System.out.println(res.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUser().getEmail());
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertTrue(loginResponse.getToken()!=null);
	}
}

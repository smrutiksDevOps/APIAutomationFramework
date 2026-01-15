package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.AddUserRequest;
import com.api.models.response.LoginRespons;

import io.restassured.response.Response;

public class AddUserTest {
	@Test(description="Verify if Add User api is working!!!")
	public void LoginTest(){
		 AddUserRequest addUser = new AddUserRequest.Builder()
				 	.email("binita123@gmail.com")
					.firstName("Binitaa")
					.lastName("Sahu")
					.password("Binita123")
					.build();
		
		UserService userService = new UserService();
		Response response = userService.AddUser(addUser);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}

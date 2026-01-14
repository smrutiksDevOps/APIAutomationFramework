package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	@Test(description="Verify if login api is working!!!")
	public void LoginTest()
	{
		RestAssured.baseURI = "http://64.227.160.186:8080/";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y= x.header("Content-Type", "application/json");
		RequestSpecification z= y.body("{\r\n"
				+ "  \"username\": \"smruti1234\",\r\n"
				+ "  \"password\": \"smruti1234\"\r\n"
				+ "}");
		Response response=z.post("api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}

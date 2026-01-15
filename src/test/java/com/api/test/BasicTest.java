package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicTest {
	
	@Test(description="Verify if login api is working!!!")
	public void LoginTest()
	{
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com/";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y= x.header("Content-Type", "application/json");
		RequestSpecification z= y.body("{\r\n"
				+ "  \"email\": \"sahusmrutikanta@gmail.com\",\r\n"
				+ "  \"password\": \"Smruti1234\"\r\n"
				+ "}");
		Response response=z.post("users/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

package com.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIRestAssuredTesting {

	@Test
	public void getUsersInPageTwo()
	{
		Response response = given().when().get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(response.statusCode(), 200);
	}
}

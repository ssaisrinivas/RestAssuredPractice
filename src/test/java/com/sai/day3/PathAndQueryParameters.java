package com.sai.day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathAndQueryParameters {

	@Test
	public void querryAndPathParameters() {
		
		given()
		//https://reqres.in/api/users?page=2&id=5
		
		.pathParam("mypath", "users") // path parameters
		.queryParam("page", 2) // query parameters
		.queryParam("id", 5)  // query parameters
		
		.when()
		.get("https://reqres.in/api/{mypath}")
				
		.then()
		.statusCode(200)
		.log().all();
		
		;
	}
}

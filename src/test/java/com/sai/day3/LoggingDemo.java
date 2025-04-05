package com.sai.day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo {

	@Test
	void loggingInfoTest() {

		       given()

				.when().get("https://reqres.in/api/users?page=2")
				
				.then()
				//.log().all(); // prints all logs
				//.log().body(); // prints body logs
				//.log().cookies(); // // prints cookies logs
				.log().headers(); // prints headers logs

	}
}

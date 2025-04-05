package com.sai.day7;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authentications {

	// Authentications types
	// 1.Basic
	// 2.Digest
	// 3.Preemptive
	// 4.Bearer token
	// 5.Oauth 1.0,2.0
	// 6.API Key

	// 1.Basic

	@Test(priority = 1)
	void testBasicAuthenication() {
		given().auth().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	// 2.Digest

	@Test(priority = 2)
	void testDigestAuthenication() {
		given().auth().digest("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	// 3.Preemptive

	@Test(priority = 3)
	void testPreemptiveAuthenication() {
		given().auth().preemptive().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	// 4. Bearer token

	@Test(priority = 4)
	void testBearerTokenAuthenication() {
		String bearerToken = "";

		given().headers("Authorization", "Bearer " + bearerToken)

				.when().get("https://api.github.com/user/repos")

				.then().statusCode(200).log().all();
	}

	// 5.Oauth 1.0

	// @Test(priority=5)
	void testOauth1Authenication() {
		// not working just Syntax

		given().auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")

				.when().get("url")

				.then().statusCode(200).log().all();
	}

	// 5.Oauth 2.0

	@Test(priority = 5)
	void testOauth2Authenication() {
		// not working just Syntax

		given().auth().oauth2("")

				.when().get("https://api.github.com/user/repos")

				.then().statusCode(200).log().all();
	}
	
	
	
	// 6.API Key
	@Test(priority = 6)
	void testAPIKeyAuthenication() {
		// not working just Syntax

		given().queryParam("appid", "ea0612aa3ddf1807590c8adffdbfe82a") // API KEY

				.when().get("https://api.openweathermap.org/data/2.5/forecast/daily?lat=44.34&lon=10.99&cnt=7")

				.then().statusCode(200).log().all();
	}

}

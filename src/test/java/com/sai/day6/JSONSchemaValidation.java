package com.sai.day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {
	
	@Test
	public void jSONSchemaValidation() {
		
		given()
		.when()
		.get("http://localhost:3000/store")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));		
	}

}

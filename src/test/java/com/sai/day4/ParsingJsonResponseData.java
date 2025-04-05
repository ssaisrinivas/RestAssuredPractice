package com.sai.day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponseData {

	// @Test(priority=1)
	void jsonResponseApproach1Test() {

		// Approach 1

		given().contentType("application/json")

				.when().get("http://localhost:3000/store")

				.then().statusCode(200).header("Content-Type", "application/json")
				.body("book[3].title", equalTo("The Loards of the rings")).log().all();
	}

	@Test(priority = 2)
	void jsonResponseApproach2Test() {

		// Approach 2

		Response res = given().contentType("application/json").when().get("http://localhost:3000/store");

		assertEquals(res.getStatusCode(), 200);
		assertEquals(res.getHeader("Content-Type"), "application/json");
		assertEquals(res.getBody().jsonPath().get("book[3].title").toString(), "The Loards of the rings");
	}

	@Test(priority = 2)
	void jsonResponseApproach3Test() {

		// Approach 3
		// JSONObject Class		
		boolean status=false;
		Response res = given()
				.contentType("application/json")
				.when()
				.get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.asString()); // converting the response in to json object type
		
		// Find the title of the book
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			
		String bookTitle=	jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		if(bookTitle.equals("The Loards of the rings")) {
			System.out.println(bookTitle);
			status=true;
			break;
			
		}				
			
		}
		assertEquals(status, true);
		
		float value = 0 ;
		
		//Find the total price of the book
		for(int i=0;i<jo.getJSONArray("book").length();i++) {
			
			String bookTitle=	jo.getJSONArray("book").getJSONObject(i).get("price").toString();		
				
				value=value+Float.parseFloat(bookTitle);
			}
		assertEquals(value, 852.0999755859375);
		
		}

}

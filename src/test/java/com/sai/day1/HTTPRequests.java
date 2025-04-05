package com.sai.day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*
 given(){Content type, set cookies, add authentication, add parameters, set headers info etc.... }
 
when() {All Request Types GET, POST, PUT, DELETE}

then() {Validations need to be done like status code,extract response, extract headers cookies, & response body ....  }
*/

public class HTTPRequests {

	int id;

	@Test(priority = 0)
	void getUsers() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 1)
	void createUser() {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "sai");
		data.put("job", "legend");

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

		/*
		 * .then() .statusCode(201) .log().all();
		 */

	}

	@Test(priority = 2)
	void updateUser() {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "sai srinivas");
		data.put("job", "wast fellow");

		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id)
				.then().statusCode(200).log().all();

	}

	@Test(priority = 3)
	void deleteUser() {

		given()

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();

	}

}

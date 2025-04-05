package com.sai.day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;



public class WaysToCreatePostRequestBody {
	
	Student_Pojo_Post_Request data;

	//@Test(priority=0) //1) Post Request body using HashMap
	public void postRequestsUsingHashMap() {

		HashMap data = new HashMap();
		data.put("id", 10);
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "9704312287");
		String[] courseArr = { "JAVA", "SELENIUM" };
		data.put("courses", courseArr);

		 given()

				.contentType("application/json").body(data)

				.when().post("http://localhost:3000/students")

				.then()

				.statusCode(201).body("name", equalTo("Scott")).body("location", equalTo("France"))
				.body("phone", equalTo("9704312287")).body("courses[0]", equalTo("JAVA"))
				.body("courses[1]", equalTo("SELENIUM")).header("Content-Type", "application/json").log().all();
		
		
	}
	
	
	
	
	
	//@Test(priority=1) //2) Post Request body using org.json library
	public void postRequestsUsingJsonLibrary() {

		JSONObject data = new JSONObject();

		data.put("id", "7");
		data.put("name", "Sai");
		data.put("location", "India");
		data.put("phone", "97043187");
		String[] courseArr = { "S-JAVA", "S-SELENIUM" };
		data.put("courses", courseArr);
		
		

		 given()

				.contentType("application/json").body(data.toString())

				.when().post("http://localhost:3000/students")

				.then()

				.statusCode(201).body("name", equalTo("Sai")).body("location", equalTo("India"))
				.body("phone", equalTo("97043187")).body("courses[0]", equalTo("S-JAVA"))
				.body("courses[1]", equalTo("S-SELENIUM")).header("Content-Type", "application/json").log().all();
				
	}
	
	
	
	//@Test(priority=2) //3) Post Request body using POJO Class
	public void postRequestsUsingPOJOClass() {

		 data = new Student_Pojo_Post_Request();

		data.setId(7);
		data.setName("Sai Srinivas");
		data.setLocation("Mukkollu");
		data.setPhone("97043187");
		String [] courses= { "P-JAVA", "P-SELENIUM" };
		data.setCourses(courses);		

		 given()

				.contentType("application/json").body(data)

				.when().post("http://localhost:3000/students")

				.then()
				.statusCode(201).body("name", equalTo("Sai Srinivas")).body("location", equalTo("Mukkollu"))
				.body("phone", equalTo("97043187")).body("courses[0]", equalTo("P-JAVA"))
				.body("courses[1]", equalTo("P-SELENIUM")).header("Content-Type", "application/json").log().all();
				
	}
	

	@Test(priority=3) //4) Post Request body using external Json file
	public void postRequestsUsingExternalJsonFile() throws FileNotFoundException {
 
		File file = new File(".\\body.json");
		FileReader fr = new  FileReader(file);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
				

		 given()

				.contentType("application/json").body(data.toString())

				.when().post("http://localhost:3000/students")

				.then()
				.statusCode(201).body("name", equalTo("Siva")).body("location", equalTo("China"))
				.body("phone", equalTo("165494745")).body("courses[0]", equalTo("HTML"))
				.body("courses[1]", equalTo("RestAPI")).header("Content-Type", "application/json").log().all();
				
	}
	
	
	


	//@Test(priority=4) // Delete record
	void testDelete() {

		given().when().delete("http://localhost:3000/students/"+data.getId()).then().statusCode(200);
	}

}

package com.sai.day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.day2.Student_Pojo_Post_Request;

public class SerializatonandDeserialization {
	
	// POJO ==> Serialization ----> JSON Object 
	// JSON Object ====> Deserialization ---> POJA
	
	//@Test
	void converPojo2Json() throws JsonProcessingException {
		
		// Created Java Object to POJO Object
		Student_Pojo_Post_Request data = new Student_Pojo_Post_Request();  //POJO
		
		data.setId(7);
		data.setName("Sai Srinivas");
		data.setLocation("Mukkollu");
		data.setPhone("97043187");
		String [] courses= { "P-JAVA", "P-SELENIUM" };
		data.setCourses(courses);		

		
		// Conver Java Object to Json Object (Serialization)
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonObj = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsonObj);
		
	}
	
	@Test
   void converJson2Pojo() throws JsonProcessingException {
		
		Student_Pojo_Post_Request data = new Student_Pojo_Post_Request();  //POJO
		
		String jsonData = "{\r\n"
				+ "      \"id\": 12,\r\n"
				+ "      \"name\": \"Vasu\",\r\n"
				+ "      \"location\": \"US\",\r\n"
				+ "      \"phone\": \"9887643213\",\r\n"
				+ "      \"courses\": [\r\n"
				+ "        \"Python\",\r\n"
				+ "        \"Appium\"\r\n"
				+ "      ]\r\n"
				+ "    }";		
		
		// Conver Json data to Java POJO Object (DeSerialization)
		
		ObjectMapper objMapper = new ObjectMapper();
		Student_Pojo_Post_Request pojoObj = objMapper.readValue(jsonData,Student_Pojo_Post_Request.class);
		
		System.out.println(pojoObj.getName());
		System.out.println(pojoObj.toString());		
	}
}

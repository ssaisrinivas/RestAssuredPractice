package com.sai.day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	void testGenerateDummyData() {
		
		Faker faker = new Faker();
		String fullName=faker.name().fullName();
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String userName=faker.name().username();
		String password=faker.internet().password();
		String cellNumber=faker.phoneNumber().cellPhone();
		String email=faker.internet().safeEmailAddress();
		
		System.out.println("Full Name :" +fullName);
		System.out.println("First Name :" +firstName);
		System.out.println("Last Name :" +lastName);
		System.out.println("User Name :" +userName);
		System.out.println("Password :" +password);
		System.out.println("Mobile Number :" +cellNumber);
		System.out.println("Email ID  :" +email);
		
	}

}

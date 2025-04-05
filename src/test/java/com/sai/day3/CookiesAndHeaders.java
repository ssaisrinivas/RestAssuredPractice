package com.sai.day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CookiesAndHeaders {

	// @Test(priority=0)
	void cookiesTest() {

		given().when().get("https://www.google.com/").then()
				.cookie("AEC", "AVYB7cpJSgAiz_lVvYoB73BrYLwz-UkTVb0Mzp5f-XpoXRMkFl2K1X7YQA").log().all();
	}

	// @Test(priority=1) // Cookies
	void getCookiesInfoTest() {

		Response res = given().when().get("https://www.google.com/");

		// get single cookie info
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of cookie is ======>" + cookie_value);

		Map<String, String> cookiesMap = res.getCookies();

		System.out.println("Cookies Kyes :" + cookiesMap.keySet());

		for (String key : cookiesMap.keySet()) {
			String value = res.getCookie(key);

			System.out.println("Given cookie Key is  ===> " + key + ":: and Value of cookie is ======> " + value);
		}
	}

	// @Test(priority=2) //Headers
	void getHeadersInfoValidateTest() {

		given()

				.when().get("https://www.google.com/")

				.then().header("Content-Type", "text/html; charset=ISO-8859-1").header("Server", "gws")
				.header("Content-Encoding", "gzip")
				.header("P3P", "CP=\"This is not a P3P policy! See g.co/p3phelp for more info.\"");
	}

	@Test(priority = 3) // Headers
	void getHeadersInfoTest() {

		Response res = given()

				.when().get("https://www.google.com/");

		String header = res.getHeader("Content-Type");
		System.out.println("Content-Type information form header : " + header);

		Headers headers = res.getHeaders();
		System.out.println("Server info from header : " + headers.getValue("Server"));

		System.out.println("All headers : " + headers);

		for (Header header2 : headers) {

			System.out.println("\n \n \n All headers from for loop: " + header2);
		}

	}

}

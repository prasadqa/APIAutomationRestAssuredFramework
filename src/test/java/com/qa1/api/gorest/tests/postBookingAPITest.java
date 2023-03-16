package com.qa1.api.gorest.tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.qa1.api.gorest.pojo.BookingJson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postBookingAPITest {

	/*
	 * 
	 * { "firstname" : "Jim", "lastname" : "Brown", "totalprice" : 111,
	 * "depositpaid" : true, "bookingdates" : { "checkin" : "2018-01-01", "checkout"
	 * : "2019-01-01" }, "additionalneeds" : "Breakfast" }
	 */

	@Test
	public void postAPITest() {

		String payload = BookingJson.getBookingJsonPayload("ravi", "rani", 4444, true, "lunch", "2018-01-01",
				"2019-01-01");

		Response responce = RestAssured.given().log().all().contentType(ContentType.JSON).body(payload).when().log().all()
				.post("https://restful-booker.herokuapp.com/booking");
		System.out.println(responce.getStatusCode());
		System.out.println(responce.prettyPrint());

	}

}

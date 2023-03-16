package com.qa1.api.gorest.pojo;

import org.testng.annotations.Test;

import com.qa1.api.gorest.utill.TestUtills;

/*
 * {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
Below method will give u json like above

 */


public class BookingJson {
	
	public static String getBookingJsonPayload(String firstname, String lastname, int totalprice, boolean depositpaid,String additionalneeds,String checkin, String checkout) {
		BookingDates dates =new BookingDates(checkin, checkout);
		Booking booking = new Booking(firstname, lastname, totalprice, depositpaid, dates,additionalneeds);
		String jsonPayload = TestUtills.getSerializeJson(booking);
		return jsonPayload;
		
	}
	
	
	
	

}

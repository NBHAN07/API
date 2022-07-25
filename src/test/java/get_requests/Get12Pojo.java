package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/18
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                       {
                                "firstname": "omto",
                                "lastname": "nena",
                                "totalprice": 112,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2018-01-01",
                                    "checkout": "2019-01-01"
                                },
                                "additionalneeds": "Breakfast"
                            }
     */

    @Test
    public void getPojo01(){
        //1. Step: Set the Url
        spec.pathParams("first","booking", "second", 18);

        //2. Step: Set the expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo bookingPojo = new BookingPojo("omto", "nena", 112, true,bookingDatesPojo, "Breakfast" );

        //3. Step: Send the GET Request and get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4. Step: Do Assertion
        BookingPojo actualPojo = response.as(BookingPojo.class);
        assertEquals(200, response.getStatusCode());

        assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
        assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());
        assertEquals(bookingPojo.getTotalprice(),actualPojo.getTotalprice());
        assertEquals(bookingPojo.isDepositpaid(),actualPojo.isDepositpaid());
        assertEquals(bookingPojo.getAdditionalneeds(),actualPojo.getAdditionalneeds());


        //1. Yol
        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());

        //2. Yol
        assertEquals(bookingDatesPojo.getCheckin(),actualPojo.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualPojo.getBookingdates().getCheckout());
    }
}

package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {


    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
           {
                "firstname": "Oliver",
                "lastname": "Smith",
                "totalprice": 100,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-07-18",
                    "checkout": "2022-07-19"
                },
                "additionalneeds": "Breakfast"
            }
     */

    @Test
    public void get01(){
        //1. Step: Set the Url
        spec.pathParams("first","booking","second", 22);

        //2. Step: Set the expected Data
        String expectedData = " {\n" +
                "                \"firstname\": \"Oliver\",\n" +
                "                \"lastname\": \"Smith\",\n" +
                "                \"totalprice\": 100,\n" +
                "                \"depositpaid\": true,\n" +
                "                \"bookingdates\": {\n" +
                "                    \"checkin\": \"2022-07-18\",\n" +
                "                    \"checkout\": \"2022-07-19\"\n" +
                "                },\n" +
                "                \"additionalneeds\": \"Breakfast\"\n" +
                "            }";


        BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

        //3. Step: Send the Get Request get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);

        //Hard Assertion
//        assertEquals(200, response.getStatusCode());
//        assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
//        assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
//        assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
//        assertEquals(expectedDataPojo.isDepositpaid(),actualDataPojo.isDepositpaid());
//        assertEquals(expectedDataPojo.getAdditionalneeds(),actualDataPojo.getAdditionalneeds());
//        assertEquals(expectedDataPojo.getBookingdates().getCheckin(),actualDataPojo.getBookingdates().getCheckin());
//        assertEquals(expectedDataPojo.getBookingdates().getCheckout(),actualDataPojo.getBookingdates().getCheckout());

        //Soft Assertion
        //1. Adım: SoftAssert objesi oluştur
        SoftAssert softAssert = new SoftAssert();

        //2. Adım: Assertion Yap
        softAssert.assertEquals(actualDataPojo.getFirstname(), expectedDataPojo.getFirstname(),"Firstname uyuşmadı");
        softAssert.assertEquals(actualDataPojo.getLastname(), expectedDataPojo.getLastname(),"Lastname uyuşmadı");
        softAssert.assertEquals(actualDataPojo.getTotalprice(), expectedDataPojo.getTotalprice(),"Total Price uyuşmadı");
        softAssert.assertEquals(actualDataPojo.isDepositpaid(), expectedDataPojo.isDepositpaid(),"Depositpaid uyuşmadı");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckin(), expectedDataPojo.getBookingdates().getCheckin(),"Checkin uyuşmadı");
        softAssert.assertEquals(actualDataPojo.getBookingdates().getCheckout(), expectedDataPojo.getBookingdates().getCheckout(),"Checkout uyuşmadı");

        //3. Adım: assertAll() methodunu çalıştır.
        softAssert.assertAll();

    }
}

package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post02 extends HerOkuAppBaseUrl {
 /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test
    public void post01(){
        // 1. set the url
        spec.pathParam("first","booking");

        // 2. set the expected data
        HerOkuAppTestData expectedData=new HerOkuAppTestData();
        Map<String, String> bookingdatesMap = expectedData.bookingdatesSetUp("2021-09-09","2021-09-21");
        Map<String, Object> expectedDataMap = expectedData.expectedDataSetUp("John","Doe",11111,true,bookingdatesMap);

        //3. send post request and get response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();

        //4. do assertion
        Map <String,Object> actualDataMap=response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("firstname"),((Map)actualDataMap.get("booking")).get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), ((Map)actualDataMap.get("booking")).get("lastname") );
        assertEquals(expectedDataMap.get("totalprice"),((Map)actualDataMap.get("booking")).get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),((Map)actualDataMap.get("booking")).get("depositpaid"));

        assertEquals(bookingdatesMap.get("checkin"), ((Map) ((Map) actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) ((Map) actualDataMap.get("booking")).get("bookingdates")).get("checkout"));






    }





    
}

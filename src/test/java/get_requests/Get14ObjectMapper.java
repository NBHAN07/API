package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper extends JsonPlaceHolderBaseUrl {
     /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get01ObjectMapper(){
        //1. Step: Set the Url
        spec.pathParams("first","todos","second",198);

        //2. Step: Set the expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        String expectedData = jsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);

        HashMap<String, Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        //3. Step: Send the Get Request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4. Step: Do Assertion
        HashMap<String, Object> actualDataMap = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));

    }
    //En İyi Yöntem
    @Test
    public void get02ObjectMapper(){

        //1. Step: Set the Url
        spec.pathParams("first","todos","second",198);

        //2. Step: Set the expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        String expectedData = jsonPlaceHolderTestData.expectedDataInString(10,"quis eius est sint explicabo",true);

        JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);

        //3. Step: Send the Get Request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4. Step: Do Assertion
        JsonPlaceHolderPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(),JsonPlaceHolderPojo.class);

        assertEquals(200, response.getStatusCode());

        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());

    }

}
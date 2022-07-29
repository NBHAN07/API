package post_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Post05 extends DummyRestApiBaseUrl {

     /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
       Test Case: Type by using Gherkin Language
       Assert:
                    {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                     }
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/create
         {
         "employee_name": "Tom Hanks",
         "employee_salary": 111111,
         "employee_age": 23,
         "profile_image": "Perfect image",
         "id": 4891
         }
    When
        User sends the POST Request
    Then
        Status code is 200
    And
         {
           "status": "success",
           "data": {
                    "employee_name": "Tom Hanks",
                     "employee_salary": 111111,
                     "employee_age": 23,
                      "profile_image": "Perfect image",
                      "id": 4891
                     },
            "message": "Successfully! Record has been added."
          }

     */

    @Test
    public void post01(){
        spec.pathParam("first","create");
        DummyApiDataPojo dummyApiDataPojo = new DummyApiDataPojo("Tom Hanks",111111,23,"Perfect image");
        DummyApiResponseBodyPojo expectedData = new DummyApiResponseBodyPojo("success",dummyApiDataPojo,"Successfully! Record has been added.");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyApiDataPojo).when().post("/{first}");
        response.prettyPrint();
        DummyApiResponseBodyPojo actualData = JsonUtil.convertJsonToJavaObject(response.asString(),DummyApiResponseBodyPojo.class);
        System.out.println(actualData);

        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getStatus(),actualData.getStatus());

        assertEquals(expectedData.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getData().getProfile_image(),actualData.getData().getProfile_image());

    }
}

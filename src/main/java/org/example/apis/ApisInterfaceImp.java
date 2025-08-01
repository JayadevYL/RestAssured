package org.example.apis;

import io.restassured.RestAssured;
import org.example.utils.ConfigReader;

import static io.restassured.RestAssured.*;

public class ApisInterfaceImp<T,R> {
    public R postApiRequest(String endPoint,T requestBody,Class<R> responseClass) {
        RestAssured.baseURI= ConfigReader.getProperties("baseUrl");
        String apiKey=ConfigReader.getProperties("token");
       R response=given().log().all().header("Content-Type","application/json")
                .header("x-api-key",apiKey)
                .body(requestBody)
                .when().post(endPoint)
                .then().extract().as(responseClass);
        return response;
    }
}

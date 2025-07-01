package org.example.Practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Basics {
    public static void main(String[] args) {

        RestAssured.baseURI="https://rahulshettyacademy.com";
           String addCart= given().log().all().queryParam("key","qaclick123").header("content-type","application/json")
                   .body("{\n" +
                           "  \"location\": {\n" +
                           "    \"lat\": -38.383494,\n" +
                           "    \"lng\": 33.427362\n" +
                           "  },\n" +
                           "  \"accuracy\": 50,\n" +
                           "  \"name\": \"Frontline house\",\n" +
                           "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                           "  \"address\": \"29, side layout, cohen 09\",\n" +
                           "  \"types\": [\n" +
                           "    \"shoe park\",\n" +
                           "    \"shop\"\n" +
                           "  ],\n" +
                           "  \"website\": \"http://google.com\",\n" +
                           "  \"language\": \"French-IN\"\n" +
                           "}").when().post("/maps/api/place/add/json")
                    .then().log().all().assertThat().statusCode(200).body("status",equalTo("OK")).extract().response().asString();

        JsonPath js=new JsonPath(addCart);
        String placeId=js.getString("place_id");
          String updateCart= given().queryParam("place_id",placeId).queryParam("key","qaclick123").header("content-type","application/json")
                  .body("{\n" +
                          "\"place_id\":\""+placeId+"\",\n" +
                          "\"address\":\"70 winter walk, USA\",\n" +
                          "\"key\":\"qaclick123\"\n" +
                          "}")
                   .when().put("maps/api/place/update/json")
                   .then().assertThat().statusCode(200).extract().toString();
    }
}

package org.example.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.Pojo.GetResponse;

import static io.restassured.RestAssured.*;

public class OauthTest {
    public static void main(String[] args) {
        RestAssured.baseURI="https://rahulshettyacademy.com";

       String response= given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type","client_credentials")
                .formParams("scope","trust")
                .log().all()
                .when().post("oauthapi/oauth2/resourceOwner/token")
                .then().log().all().assertThat().statusCode(200).extract().asString();

        JsonPath jp=new JsonPath(response);
        String accessToken=jp.getString("access_token");


        GetResponse getResponse=given().queryParams("access_token", accessToken)
                .when().get("oauthapi/getCourseDetails")
                .then().log().all().assertThat().statusCode(401).extract().as(GetResponse.class);

        System.out.println(getResponse.getLinkedIn());

    }
}

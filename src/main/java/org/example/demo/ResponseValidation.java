package org.example.demo;

import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.Map;

/*
1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount
**/
public class ResponseValidation {
    public static void main(String[] args) {
        JsonPath js=new JsonPath(Json.response());
        int numberOfCourse=js.getInt("courses.size()");
        System.out.println("numberOfCourse="+numberOfCourse);
        int purchaseAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println("purchaseAmount="+purchaseAmount);
        String titleOfFirstCourse=js.getString("courses[0].title");
        System.out.println("First name of the Course="+titleOfFirstCourse);
        System.out.println(List.of(js.getList("courses")));
        // Extract list of courses as List of Map
        List<Map<String, Object>> courses = js.getList("courses");

        // Use Stream to find "RPA" course and print copies
        int rpaCopies = courses.stream()
                .filter(course -> course.get("title").equals("RPA"))
                .map(course -> (Integer) course.get("copies"))
                .findFirst()
                .orElse(0);

        System.out.println("Copies sold by RPA Course: " + rpaCopies);
    }
}

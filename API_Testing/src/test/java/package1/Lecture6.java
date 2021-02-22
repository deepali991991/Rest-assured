package package1;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class Lecture6 {
	
	
	@Test
	public void testGet()
	{
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].first_name", equalTo("Lindsay")).
		body("data.first_name", hasItems("Michael", "Tobias","Byron"));
	}

	
	
	@Test
	public void postrequest()
	{
		JSONObject request = new JSONObject();
		request.put("Name", "Deepali");
		request.put("Profile", "QA");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().body(request.toJSONString()).when().post("/users?page=2").then().statusCode(201);
	}
}

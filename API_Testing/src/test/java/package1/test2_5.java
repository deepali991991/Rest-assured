package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class test2_5 {
	
	@Test
	public void test1()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(response.getTime());
		Assert.assertEquals(statuscode, 200);
		System.out.println(response.getBody().asString());
		
	}

	@Test
	public void test22()
	{
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8)).
		body("data[0].id", equalTo(7));
	}
}

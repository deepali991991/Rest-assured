package package1;

import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class lecture5 {
	
	
	@Test
	public void test1()
	{
		Response response=get("https://reqres.in/api/users?page=2");
		int statuscode = response.getStatusCode();
		System.out.println("status code is"+statuscode);
		
	}
	
	@Test
	public void test2()
	{
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
	}
	
	
	

}

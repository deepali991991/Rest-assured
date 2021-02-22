package package1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class simple_test {
	
	@Test
	public void test1()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		System.out.println(response.getTime());
		Assert.assertEquals(statuscode, 200);
		System.out.println(response.getBody().asString());
	}
	
}

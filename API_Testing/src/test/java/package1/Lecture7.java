package package1;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

//Put, Patch, delete
public class Lecture7 {
	
	
	@Test(priority=1)
	public void Putmethod()
	{
		
		JSONObject request= new JSONObject();
		
		request.put("Name", "Deepali");
		request.put("Profile", "Automation QA");
		
		baseURI="https://reqres.in/api";
		
		given().body(request.toJSONString()).when().put("/users/2").then().statusCode(200);	
		
		System.out.println(request.toJSONString());
		
	}
	
	@Test(priority=2)
	public void PatchTest()
	{
		
        JSONObject request= new JSONObject();
		
		request.put("Name", "rahul");
		request.put("Profile", "Automation QA");
		
		baseURI="https://reqres.in";
		
		given().body(request.toJSONString()).when().patch("/api/users/2").then().statusCode(200);	
		
		System.out.println(request.toJSONString());
	}

	@Test(priority=3)
	public void delete()
	{

		
		baseURI="https://reqres.in";
		
		when().delete("/api/users/2").then().statusCode(204);	
		
		
	}
}

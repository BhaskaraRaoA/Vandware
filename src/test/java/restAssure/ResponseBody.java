package restAssure;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class ResponseBody {
	@Test
	public void responseBody()
	{
	
		RequestSpecification req = RestAssured.given();
		
		req.baseUri("https://reqres.in/");
		req.basePath("/api/users?page=2");
		
		Response res = req.get();
	   
	   String rbody=res.asString();
	   
	   System.out.println(rbody);
		
		//Assert.assertEquals(rbody.contains("George"),true);
		// x.data[4].first_name
		
		JsonPath jpath = res.jsonPath();
		String firstname= jpath.get("x.data[3].first_name");
		
		Assert.assertEquals(firstname,"Byron");
		
		
		
	}

}

package restAssure;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Quary_Parameter {
 @Test
	public void QuaryParam()
	{
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://reqres.in").param("id", 2);
		req.basePath("/api/users");
		//req.param("page", "3");
		//req.param("page", 2);
		req.param("page","1");
		
		Response res = req.get();
		
		String resbody = res.getBody().asString();
		
		System.out.println(resbody);
	}
	
}

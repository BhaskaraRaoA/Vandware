package authentications;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Basic_Auth {
 @Test
	public void BasicAuth()
	{
		
		RequestSpecification req = RestAssured.given();
		req.baseUri("http://postman-echo.com/");
		req.basePath("/basic-auth");
		
		Response res = req.auth().preemptive().basic("postman", "password").get();
		
		System.out.println(res.getStatusLine());
	
	}
 @Test
 public void digestAuth()
 {
	// https://httpbin.org/ to create authentication for new users	 
	 RequestSpecification req = RestAssured.given();
		req.baseUri("https://httpbin.org");
		req.basePath("/digest-auth/undefined/Bhaskar/bhaskar");
		
		Response res = req.auth().digest("Bhaskar","bhaskar").get();
		
		System.out.println(res.getStatusLine());
		System.out.println(res.body().asString());
		Assert.assertEquals(res.getStatusLine(),"HTTP/1.1 200 OK");
	
 }
}

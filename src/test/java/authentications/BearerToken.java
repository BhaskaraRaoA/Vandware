package authentications;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BearerToken {
@Test
	public void Bearertoken()
	{
	RequestSpecification req = RestAssured.given();
	req.baseUri("https://gorest.co.in");
	req.basePath("/public/v2/users");
	
	JSONObject payload= new JSONObject(); 
	payload.put("name","Bhaskar");
	payload.put("lastname","Annepu");
	payload.put("gmail","bhaskar0143@gmail.com");
	payload.put("status", "Active");
	

	
	String AuthToken = "Bearer 866218be3a275e793abe788f9a83a53da434004c5718abd6215cd26d5fc6fc6be2b";
	req.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(payload.toJSONString());
	
	Response response = req.post();
	System.out.println(response.statusLine());
	System.out.println(response.body().asString());
	System.out.println(response.getStatusCode());
	Assert.assertEquals(response.statusCode(),522);
	
	}	
}

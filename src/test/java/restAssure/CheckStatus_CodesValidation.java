package restAssure;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CheckStatus_CodesValidation {
	@Test
	public void codeValidation()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		// 1st validation
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		// 2nd validation
		String Statuscode = response.getStatusLine();
		Assert.assertEquals(Statuscode,"HTTP/1.1 200 OK", "Sucessfully Validated");
		
	}
@Test
	public void singleUser_BDDStyle()
	{
		RestAssured.given().
		
		when().get("https://reqres.in/api/users/2").
		
		then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}
	@Test
public void validation_03()
{
	RequestSpecification req = RestAssured.given();
	req.baseUri("https://reqres.in");
	req.basePath("/api/users/2");
     
	Response res = req.get();
	
	// validate response content type
	String header=res.getHeader("ContentType");
	System.out.println("ContentType"+header);
	
}	@Test
	public void connection()
	{
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://reqres.in");
		req.basePath("/api/users/2");
		
		Response res = req.get();
		String connection= res.getHeader("Connection");
		System.out.println("connection is"+connection);
		
		Assert.assertEquals(connection,"keep-alive");
		
	}
@Test
public void Headers_00()
{
	
	RequestSpecification req = RestAssured.given();
	req.baseUri("https://reqres.in");
	req.basePath("/api/users/2");
	
	Response res = req.get();
	
	Headers headList=res.getHeaders();
	
	for (Header h:headList)
	{
		System.out.println("Key"+h.getName()+"Value"+h.getValue());
	}

}

public void validationResponseBody04()
{

	RequestSpecification req = RestAssured.given();
	
	req.baseUri("https://reqres.in/api/users?page=2");
	req.basePath("/api/users?page=2");
	
	//response body
	
	Response res = req.get();
	
	
	String rbody=res.asString();
	System.out.println("response body of given statement is"+rbody);
	
	
	
	
}
}

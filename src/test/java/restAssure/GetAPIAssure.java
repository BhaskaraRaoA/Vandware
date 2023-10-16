package restAssure;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPIAssure {
	@Test
	public void get()
	{
	   Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	
	System.out.println(response.getStatusCode());
	System.out.println(response.getTime());
	System.out.println(response.getContentType());
	System.out.println(response.asString());
	System.out.println(response.toString());
	
	int ActualStatuscode=200;
	int ExpectedStatuscode=200;
	
	Assert.assertEquals(ActualStatuscode, ExpectedStatuscode);
	Assert.assertEquals(200, ActualStatuscode);
	
	
	}
	@Test
public void test02()
{
  RestAssured.baseURI="https://reqres.in/api/users";
  RestAssured.given().param("page", "2").
  when().get().
  then().statusCode(200);		
}
}












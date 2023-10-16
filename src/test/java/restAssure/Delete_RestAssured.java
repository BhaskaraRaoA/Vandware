package restAssure;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete_RestAssured {
@Test
	public void delete()
	{
		
		RestAssured.baseURI="https://reqres.in/api/users/435";
		RestAssured.given().
		when().delete().
		then().log().all().statusCode(204);
	}
	
	
}

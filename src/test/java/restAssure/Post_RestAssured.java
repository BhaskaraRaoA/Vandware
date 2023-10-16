package restAssure;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post_RestAssured {
@Test

	public void post()
	{
		JSONObject  obj= new JSONObject();
		obj.put("name","Bhaskar");
		obj.put("Education","Master's Science");
		obj.put("Wife Name","Haritha");
		obj.put("age",24);
		obj.put("job", "Software"); 
		obj.put("Location","Hyderabad");
		
		RestAssured.baseURI=("https://reqres.in/api/users/");
		RestAssured.given().header("Content-Type","Application/JSON").
		contentType(ContentType.JSON ).body(obj.toJSONString()).
		when().
		post().
		then().statusCode(201).log().all();
		
		
		
		
		
		 
	}
	
	
	
}

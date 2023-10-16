package restAssure;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Put_ResrAssured {
	@Test
	public void patch()
	{
		JSONObject  obj= new JSONObject();
		obj.put("name","Bhaskar");
		obj.put("Education","Master's Science");
		obj.put("Wife Name","Haritha");
		obj.put("mother name", "Yasodha");
		obj.put("age",24);
		obj.put("brother name", "Nagaraju"); 
		obj.put("Location","Hyderabad");
		
		RestAssured.baseURI=("https://reqres.in/api/users/435");
		RestAssured.given().header("Content-Type","Application/JSON").
		      contentType(ContentType.JSON ).body(obj.toJSONString()).
		when().
		      put().
		then().statusCode(200).log().all();
	}
	

}

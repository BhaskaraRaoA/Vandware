package restAssure;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Patch_RestAssured {
@Test
	public void patch()
	{
		JSONObject  obj= new JSONObject();
		obj.put("name","Bhaskar");
		obj.put("Education","Master's Science, BSc");
		obj.put("Wife Name","Haritha");
		obj.put("age",26);
		obj.put("job", "Software Test Engineer"); 
		obj.put("Location","Hyderabad");
		
		RestAssured.baseURI=("https://reqres.in/api/users/435");
		RestAssured.given().header("Content-Type","Application/JSON").
		         contentType(ContentType.JSON ).body(obj.toJSONString()).
		when().
		         patch().
		then().statusCode(200).log().all();
	}
	
}

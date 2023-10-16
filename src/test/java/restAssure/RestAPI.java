package restAssure;



import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI {
	@Test
	public void APitesting()
	{
		System.out.println("to Start the rest assured");
	
	JSONObject obj = new JSONObject();
	obj.put("name", "Bhaskar");
	obj.put("Age", 26);
	obj.put("JOb", "Software Engineer");
	obj.put("Wife","Haritha");
	obj.put("age", "24");
	

	RequestSpecification req = RestAssured.given();
    	req.body(obj);
    	req.contentType(ContentType.JSON);
	Response res = req.post("https://reqres.in/api/users/2");
	res.then().log().all();
    	
    	
    	
	}

}

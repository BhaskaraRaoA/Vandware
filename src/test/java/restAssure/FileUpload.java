package restAssure;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FileUpload {
@Test
	public void fileUploadToAPI()
	{
		File docfileupload= new File("C:\\Users\\bhask\\OneDrive\\Pictures\\Screenshots");
	
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
		req.multiPart("file", docfileupload);
		req.contentType(ContentType.JSON);
		req.body("multidatafile");
		
		Response res = req.post();
		
		res.prettyPrint();
		Assert.assertEquals(res.statusCode(),200);
		
		
		
		
		
		
		
	}
	
}

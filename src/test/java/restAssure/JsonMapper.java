package restAssure;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class JsonMapper {
	
	@Test
	public void ObjectMapper()
	{
		// create the object mapper
		
		ObjectMapper om = new ObjectMapper();
		
		// create the object node
		
		ObjectNode on=om.createObjectNode();
		on.put("Name","Bhaskar");
		on.put("FirstName", "Annepu");
		on.put("Age", "26");
		on.put("MaritalStatus",false);
		on.put("Job", "TCS");
		on.put("Gmail","bhaskar.bh143@gmail.com"); 
		on.put("wifename", "HARITHA");
		// to add the arrays list values
		
		on.set("locations",om.convertValue(Arrays.asList("Hyderabad,bangalure"),JsonNode.class));
		ObjectNode skills=om.createObjectNode();
		
		skills.put("Automation", "Selenium");
		skills.put("language", "Java");
		skills.put("API testing", "RestAssured");
		skills.put("projectManagementTool","jira");
		
		on.set("Skills", skills);
		
	// print the json object	
		
		String userDetailsAsString = null;
		try {
			userDetailsAsString = om.writerWithDefaultPrettyPrinter().writeValueAsString(skills);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created Json node object"+userDetailsAsString);
		
		// Retrive the field data
		
		String name= on.get("Name").asText();
		System.out.println(name);
		
		String firstname= on.get("FirstName").asText();
		System.out.println(firstname);
		
		String gmail=on.get("Gmail").asText();
		System.out.println(gmail);
		
		Boolean marriage= on.get("MaritalStatus").asBoolean();
		System.out.println(marriage);
		
		String language= skills.get("language").asText();
		System.out.println(language);
		
		System.out.println("-----------Field values------------------ ");
		
		Iterator <String>FieldValueIterator=  on.fieldNames();
		while(FieldValueIterator.hasNext())
		{
			String values= FieldValueIterator.next();
			System.out.println(values);
		}
		
		System.out.println("-------------second data---------------------");
		Iterator <String>FieldvaluesIterator=  skills.fieldNames();
		while(FieldvaluesIterator.hasNext())
		{
			String value= FieldvaluesIterator.next();
			System.out.println(value);
		}
		
		
		
		
		System.out.println("-------------Filed names----------------");
		
		Iterator <String>FieldNamesIterator=  on.fieldNames();
		while(FieldNamesIterator.hasNext())
		{
			String names= FieldNamesIterator.next();
			System.out.println(names);
		}
		System.out.println("--------------------second Data-------------------");
		
		Iterator <String>FieldnamesIterator=  on.fieldNames();
		while(FieldnamesIterator.hasNext())
		{
			String names= FieldnamesIterator.next();
			System.out.println(names);
		}
		
		System.out.println("-------------Print All fields and Values-------------");
		
		Iterator<JsonNode> filedvalueIterator= on.elements();
		
		while(filedvalueIterator.hasNext())
		{
			System.out.println(filedvalueIterator.next());
		}
		
		System.out.println("===========print key values===============");
		
		Iterator<Entry<String,JsonNode>> keyValues=on.fields();
		
		while(keyValues.hasNext())
		{
			Entry<String,JsonNode> node=keyValues.next();
			
			System.out.println("key names  :" +" ------- "+node.getKey()+","+"get the key values  :  "+node.getValue());
		}
		
	on.remove(gmail);
	on.put("lovername","haritha");
	
	String userDetailsAsString1 = null;
	try {
		userDetailsAsString1 = om.writerWithDefaultPrettyPrinter().writeValueAsString(skills);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Created Json node object"+userDetailsAsString1);
	System.out.println(on);
	
	
	RequestSpecification req = RestAssured.given();
	req.baseUri("https://reqres.in/api/users");

	
	req.contentType(ContentType.JSON).body(on);
	
	Response res = req.post();
System.out.println("=============print the response body================");
	res.prettyPrint();
	
	
	
	Assert.assertEquals(res.statusCode(), 201);
	
	
	
	
	}

}

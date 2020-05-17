package demo;

import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class DemoMethods {

	@Test
	public void testGet() {
		given().
			get("https://petstore.swagger.io/v2/pet/findByStatus?status=new").
	    then().
			statusCode(200).log().all();
	}
	
	@Test
	public void testPost() {
		/**
		 * https://reqres.in/api/users
		 */
		given().body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").and().
		when().post("https://reqres.in/api/users").
		then().statusCode(201).log().all();
		
	}
}

package demo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class PostTest {

	@Test
	public void testPost() {
		baseURI	="https://reqres.in";
//		Map.put("job", "“Teacher");
//		System.out.println (map);
		JSONObject request = new JSONObject ();
		request.put ("name", "Raghav");
		request.put("job", "Teacher") ;
		System. out.println (request) ;
		System. out.println (request .toJSONString());
		given().
			header ("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body (request .toJSONString()).
		when().
			post ("/api/users").
		then().
			statusCode (201);
	}
}

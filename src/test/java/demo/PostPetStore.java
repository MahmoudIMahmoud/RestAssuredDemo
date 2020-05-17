package demo;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class PostPetStore {

	@Test
	public void testAddPet() {
		baseURI="https://petstore.swagger.io";
		JSONObject request = JsonLoad.loadJsonTemplateFromFile("./templates/PetSample.json");
		given().
		header ("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body (request .toJSONString()).
	when().
		post ("/v2/pet").
	then().
		statusCode (200);
	}
}

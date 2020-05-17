import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestCallsTest {

	
	@Test
	public void test_get_01() {
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}
	
	@Test
	public void test_post_01() {
		Response response = RestAssured.post("https://reqres.in/api/users/2");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}
}

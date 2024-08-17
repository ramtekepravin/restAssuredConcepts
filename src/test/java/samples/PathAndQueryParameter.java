package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import org.hamcrest.Matchers;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	// sample -- https://reqres.in/api/users?page=2&id=7
	
	@Test
	public void getSingleUser()
	{
		
	given()
	  .contentType("application/json")
	  .pathParam("mypath", "users")
	  .queryParam("page", 2)
	  .queryParam("id", 5)
	   
	.when()
	     .get("https://reqres.in/api/{mypath}")
	
	
	.then()
	   .statusCode(200)
	   .body("data.first_name", Matchers.equalTo("Charles"))
	   .body("data.id", Matchers.equalTo(5))
	   .log().all();
	
	
		  
		
	}

}

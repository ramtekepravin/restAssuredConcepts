package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.JSONObject;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorDemo {
	
	// Json to JsonSchema Convertor
	//https://jsonformatter.org/json-to-jsonschema
	
	
        @Test
		public void getUsers()
		
		{
			given()
			   .contentType("application/json")
			   .pathParam("mypath","users")
			   .queryParam("page",2)
			
			.when()
			    .get("https://reqres.in/api/{mypath}")
			    
			.then()
			   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SchemaValidator.json"));
		
		}
        
}


package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;


public class XMLSchemavalidatorDemo {
	
	
	//XML to XSD Convertor
	// https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/
	
	public void xmlschemavalidateTest()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		  
		  .then()
		    .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLValidate.xsd"));
		  
		    
	}

}

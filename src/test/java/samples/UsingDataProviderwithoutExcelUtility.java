package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
// import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import utility.Dataproviderwithoutexcelmethods;

import static io.restassured.matcher.RestAssuredMatchers.*;



public class UsingDataProviderwithoutExcelUtility {
	
	int id;
	
	
	
	@Test(priority = 1)
	public void getUserList()
	{
		
		given()
		   .contentType("application/json")
		   
		.when()
		   .get("https://reqres.in/api/users?page=2")
		
		.then()
		   .statusCode(200)
		   .body("page",Matchers.equalTo(2))
		   .log().all();
		
	}
	
	@Test (priority = 2, dataProvider = "getData", dataProviderClass = Dataproviderwithoutexcelmethods.class )
	public void createUser(String name , String job)
	{
		 
	
		id = given()
		   .contentType("application/json")
		   .body(JsonPath.parse(name))
		   .body(JsonPath.parse(job))
		   
		  
		   
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id"); 	
		
	}
	
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	public void updateUser() 
	{
		Pojoclassfordata data1 = new Pojoclassfordata();
		data1.setName("Kiran");
		data1.setJob("OfficeBoy");

		
		
		 given()
		   .contentType("application/json")
		   .body(data1)

		.when()
		  .put("https://reqres.in/api/users/"+id)
		  
		 .then()
		    .statusCode(200)
		    .log().all();
	}	
		  
	
	
	@Test(priority = 4 , dependsOnMethods = {"createUser"})
	public void deleteUser()
	{
		given()
		   .contentType("application/json")
		   

		.when()
		  .delete("https://reqres.in/api/users/"+id)
		  
		 .then()
		    .statusCode(204);
		    
	}	

		
	}


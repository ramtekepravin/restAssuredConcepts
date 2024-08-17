package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;



public class Example1 {
	
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
	
	@Test (priority = 2)
	public void createUser()
	{
		/*HashMap data = new HashMap();
		data.put("name", "Pravin");
		data.put("job","QA Lead");*/
		
		JSONObject data = new JSONObject();
		data.put("name", "Pravin");
		data.put("job","QA Lead");

		
		
		id = given()
		   .contentType("application/json")
		   .body(data.toString()) // if data is created using JSONObjet them ned to add .toString() in body
		   
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id"); 	
		
	}
	
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	public void updateUser() 
	{
		
		HashMap data1= new HashMap();
		data1.put("name", "Ranjan");
		data1.put("job","Admin");
		
		
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


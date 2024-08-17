package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;



public class UsingPojoClassData {
	
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
		Pojoclassfordata data = new Pojoclassfordata();
		data.setName("Pravin");
		data.setJob("Lead");
		
		
		id = given()
		   .contentType("application/json")
		   .body(data) // if data is created using JSONObjet them ned to add .toString() in body
		   
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


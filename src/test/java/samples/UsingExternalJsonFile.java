package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import org.hamcrest.Matchers;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class UsingExternalJsonFile {
	
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
	public void createUser() throws Exception
	{
		
		File f = new File("./src/test/resources/TestData/bodyData.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
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


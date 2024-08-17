package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class ValidatingResponse {
	
	//https://reqres.in/api/users?page=2
	//Approach1
	//Validating response using restassured assertions when we use then() part. But in this we can validate limited validations.
	
	//@Test
/*	public void getUsers()
	
	{
		given()
		   .contentType("application/json")
		   .pathParam("mypath","users")
		   .queryParam("page",2)
		
		.when()
		    .get("https://reqres.in/api/{mypath}")
		
		.then()
		  .statusCode(200)
		  .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
		  .header("Server","cloudflare")
		  .body("page", Matchers.equalTo(2))
		  .body("data[0].email", Matchers.equalTo("michael.lawson@reqres.in"))
		  .body("data[1].first_name", Matchers.equalTo("Lindsay"));
       } */
     
		
// Approach 2 -
//- here we doc not add then() part and save the response in variable of type Response, then do assertion using TestNG to validate 
 	
		      
		//@Test
		public void getUsers2()
		
		{
			// storing the response in variable res of type Response
			Response res =                    
			
			given()
			   .contentType("application/json")
			   .pathParam("mypath","users")
			   .queryParam("page",2)
			
			.when()
			    .get("https://reqres.in/api/{mypath}");
			    
			 Assert.assertEquals(res.getStatusCode(), 200);  // TestNG assertion  validate status code
			 Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8"); // validate header
			 
			 // below code will work only if the object location do not change since we are validating data using index level
			 
			 String email = res.jsonPath().get("data[1].email").toString(); // get value from response body
			 Assert.assertEquals(email, "lindsay.ferguson@reqres.in");      // validating response body value
			 
			 String firstname= res.jsonPath().get("data[2].first_name").toString();
			 Assert.assertEquals(firstname, "Tobias"); 
			 
		}	 
 
			 
// Approach 3
// Another way to validate response body value		
		
			 
			    @Test
				public void getUsers3()
				
				{
					// storing the response in variable res of type Response
					Response res =                    
					
					given()
					   .contentType("application/json")
					   .pathParam("mypath","users")
					   .queryParam("page",2)
					
					.when()
					    .get("https://reqres.in/api/{mypath}");
					     
					 // Convert the json response to JSONObject first and then get all value of field and then validate
					 
					 JSONObject jo = new JSONObject(res.asString()); // converting json response to JSONObject
					 
					 boolean status = false;
					 for (int i = 0 ; i< jo.getJSONArray("data").length() ; i++)
					 {
						   String email = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
						   System.out.println(email);
						   
						   if (email.equals("tobias.funke@reqres.in"))
						   {
							   status = true;
							   break;
						   }
					 }
					 Assert.assertEquals(status,true);	
		
	              }

}

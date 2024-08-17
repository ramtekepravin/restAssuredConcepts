package samples;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.hamcrest.Matchers;

import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;


public class AuthorizationTest {
	
	//In simple terms, authentication is the process of verifying who a user is,
	//while authorization is the process of verifying what they have access to
	/* Types of Authentication
	 1. Basic -- UserName / Password
	 2. Digest -- UserName / Password
	 3. Preemptive -- UserName / Password
	 4. OAuth 1.0 , 2.0
	 5. API Key
	 6. Bearer Token
	 */

	// Basic Authorization
	
	@Test
    public void basicAuthorization()
    {
    	
	    given()
	      .auth().basic("postman","password" )
	    
	    .when()
	      .get("https://postman-echo.com/basic-auth")
	    
	    .then()
	      .statusCode(200)
	      .body("authenticated",Matchers.equalTo(true))
	      .log().all();
	
    }
	
	// Digest Authorization
	@Test
    public void digestAuthorization()
    {
    	
	    given()
	      .auth().basic("postman","password" )
	    
	    .when()
	      .get("https://postman-echo.com/basic-auth")
	    
	    .then()
	      .statusCode(200)
	      .body("authenticated",Matchers.equalTo(true))
	      .log().all();
	
    }
	
	// Preemptive Authorization
	@Test
    public void preemptiveAuthorization()
    {
    	
	    given()
	      .auth().preemptive().basic("postman","password" )
	    
	    .when()
	      .get("https://postman-echo.com/basic-auth")
	    
	    .then()
	      .statusCode(200)
	      .body("authenticated",Matchers.equalTo(true))
	      .log().all();
	
    }
	
	
	// OAuth1 Authentication (need to pass some parameter values for (consumerKey,consumerSecrat,accessToken,tokenScrate)
	
	
	@Test
	public void oAuth1Auth()
	{
		
		
		  given()
		    .contentType("Content-Type.JSON" )
		    .auth().oauth("consumerKey","consumerSecrat","accessToken","tokenScrate")
		    
		  .when()
		     .get("URL")
		     
		   .then() 
		      .assertThat()
		      .statusCode(200)
		      .body("authenticated",Matchers.equalTo(true))
		      .log().all();
	}		
	
// OAuth2 Authentication (need to  parameter values only for (accessToken)
	
	
	@Test
	public void oAuth2Auth()
	{
		
		
		   given()
		    .contentType("Content-Type.JSON" )
		    .auth().oauth2("accessToken")
		    
		  .when()
		     .get("URL")
		     
		   .then() 
		      .assertThat()
		      .statusCode(200)
		      .body("authenticated",Matchers.equalTo(true))
		      .log().all();
	}		

// API Authentication (need to pass  API key value as Query Parameter "appid"	
	
	@Test
	public void apiKeyAuth()
	{
		
		
		   given()
		    .contentType("Content-Type.JSON" )
		    .queryParam("appid","value of api key")
		    
		  .when()
		     .get("URL")
		     
		   .then() 
		      .assertThat()
		      .statusCode(200)
		      .body("authenticated",Matchers.equalTo(true))
		      .log().all();
	}
	
	// Bearer Token Authentication (need to store bearer token value in String variable and pass that variable in header			
	@Test
	public void bearerTokenKeyAuth()
	{
		
		String bearerToken = "value of bearerToken only";
	
		  given()
		    .contentType("Content-Type.JSON" )
		    .header("Authorization" , "Bearer" + bearerToken)
		    
		  .when()
		     .get("URL")
		     
		   .then() 
		      .assertThat()
		      .statusCode(200)
		      .body("authenticated",Matchers.equalTo(true))
		      .log().all();
	}
	


}

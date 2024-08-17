package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;


import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Cookies {
	
	// Read cookies values
	
	@Test
	public void getCookies()
	{
	 Response res =	given()
		  .contentType("application/json")
		 
		
		.when()
		  .get("https://www.google.com/");
		
	  // get single cookie
	  String  singlecookievalue = res.getCookie("AEC");
	  System.out.println("Value of cookie ACE is " + singlecookievalue);
	  
	  
	 // get all cookies 
	  
	 Map<String , String>  allcookies_values = res.getCookies();
//	 System.out.println("Value of keys are " +allCookiesvalue.keySet());
//	 System.out.println("Value of keys are " +allCookiesvalue.entrySet());
	 
	 for(String k:allcookies_values.keySet())
	 {
		 String Cookiesvalue = res.getCookie(k);
		 System.out.println( k +"    "+Cookiesvalue );
		 
	 }
	 
	 
	       
		  
		  
		
		
		
		
		
		
	}

}

package samples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static io.restassured.response.Response.*;

import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class HeadersDemo {
	
	
	@Test
	public void getHeaders()
	{
	     given()
		  .contentType("application/json")
		 
		
		.when()
		  .get("https://www.google.com/")
	 
	    .then()
	      .header("Content-Type","text/html; charset=ISO-8859-1")
	      .and()
	      .header("Content-Encoding", "gzip")
	      .and()
	      .header("Server","gws");
	      		
	}
	
	
	@Test
	public void getHeadersvalue()
	{
	  Response res1 =   given()
		 //  .contentType("application/json")
		 
		
		.when()
		  .get("https://www.google.com/");
	  
	  // get Single header
	  String  header1 = res1.getHeader("Content-Type");
	  System.out.println("Value of header1 is " +header1);
		
	  //get all headers
	  
	   Headers allheaders = res1.getHeaders();
	   for (Header hd:allheaders)    
	   {
		   System.out.println(hd.getName() +"   "+hd.getValue());
	   }
	  
	} 
	
	
	
	   @Test
		public void logprint()
		{
		     given()
			 //  .contentType("application/json")
			 
			.when()
			  .get("https://www.google.com/")
			  
			 .then()
			//   .log().body(); // print only response body
		    //   .log().headers(); // print only headers
			      .log().cookies(); // print only cookies
			 
		  
		
	 
	     		
	}


}

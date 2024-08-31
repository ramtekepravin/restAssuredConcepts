package samples;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileuploadDemo {
	
	// Single File Upload
	    
	    @Test
		public void SinglefileUpload()
		{
		   File myfile = new File("F:\\My Automation\\RestAssured\\Fileupload\\Test1.txt");
		   
			RestAssured
			
			 .given()
	            .multiPart("file", "myfile")
	            .contentType("multipart/form-data")
	            
	           .when() 
	             .post("https://postman-echo.com/post")
	             
	            .then()
	              .statusCode(200) 
	              .body("fileName", Matchers.equalTo("Text1.txt"));
	              		
		}
		
		// Multiple File Upload
		
		@Test
		public void MultiplefileUpload()
		{
		   File myfile1 = new File("F:\\My Automation\\RestAssured\\Fileupload\\Test1.txt");
		   File myfile2 = new File("F:\\My Automation\\RestAssured\\Fileupload\\Test2.txt");
			RestAssured
			
			 .given()
	            .multiPart("files", "myfile1")
	            .multiPart("files", "myfile2")
	            .contentType("multipart/form-data")
	            
	           .when() 
	             .post("https://postman-echo.com/post")
	             
	            .then()
	              .statusCode(200)
	              .body("[0].fileName1",Matchers.equalTo("Test1.txt")) // as per response of File upload 
			      .body("[1].fileName2",Matchers.equalTo("Test2.txt"));
	    
		}


}

package samples;



import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class FakerClassDataGenerate {
	
	
	@Test
	public void fakerDataGeneration() 
	
	{
	    
		Faker data = new Faker();
		
		String fullname = data.name().fullName();
		String firstname = data.name().firstName();
		String lastname = data.name().lastName();
		
		String username = data.name().username();
		String password = data.internet().password();
		
		String emailid = data.internet().emailAddress();
		
		String phoneno = data.phoneNumber().cellPhone();
		
		
		System.out.println("Full name is  : " +fullname);
		System.out.println("First name is  : " +firstname);
		System.out.println("Last name is  : " +lastname);
		
		System.out.println("User Name is  : " +username);
		System.out.println("Password is  : " +password);
		
		System.out.println("Full name is  : " +emailid);
		System.out.println("Full name is  : " +phoneno);
		
	}

}

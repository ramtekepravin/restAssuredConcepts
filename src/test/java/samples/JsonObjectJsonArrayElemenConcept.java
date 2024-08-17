package samples;

public class JsonObjectJsonArrayElemenConcept {
	
	// Json Object -- Starts with {  }
	//Json Array -- starts with []
	// Element -- parameter in object
	
	/* Example
	 
	 {
	   
	   "book":
	         [
	           {
	             "name": "ABC",
	             "author": "QASD",
	             "price": 1000
	           }
	             
	           {
	             "name": "PQR",
	             "author": "TYU",
	             "price": 2000
	           }
	           
	           {
	             "name": "OPJ",
	             "author": "GFHD",
	             "price": 3000
	           }
	   
	         ]
	 
	   "shop": "xyz"
	   }
	 
	 
	Entire json is an object, book is an array and in book array there are objects
	
	 JsonObject -- JsonArray -- JsonObject -- element
	 
	 define variable for response as res of type Response
	 Convert json response to jsonObject first by passing json response variable
	 
	 JSONObject jo = new JSONObject(res.asString)
	 
	 Now navigate to element 
	   String bookname  =jo.getJSONArray("book").getJSONObject(i).get("name").toString
	 
	 
	 
	 
	 }
	 */
	

}

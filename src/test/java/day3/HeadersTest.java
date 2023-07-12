package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;



public class HeadersTest 
{

	//@Test
	public void testHeader()
	{
		
        given()
		
		.when()
		     .get("https://www.google.com")
		  
		
		.then()
		    .header("Content-Type","text/html; charset=ISO-8859-1")  
		    .header("Content-Encoding", "gzip")
		    .header("Server", "gws");
		    //.log().all();
		
	}
	
	
	@Test
	public void testHeaderInfo()
	{
		
		 Response res = given()
			
	     .when()
			 .get("https://www.google.com");
		 
//		 String value = res.getHeader("Content-Type");
//		 System.out.println(value);
		 
		 
		 Headers headers = res.getHeaders();
		 
		 for (Header i : headers) 
		 {
			System.out.println(i.getName()+"   "+i.getValue());
		 }
		 
	}
	
}

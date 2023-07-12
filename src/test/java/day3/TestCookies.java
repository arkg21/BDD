package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class TestCookies 
{

	//@Test
	public void testCookies()
	{
		
		given()
		
		.when()
		     .get("https://www.google.com")
		  
		
		.then()
		     .cookie("AEC", "Ad49MVFXeSJLpKEZOspR1kMlZIdeUdZDrkHSTdIiTQjSrgi0ymGgoRpR0i0")
		     .log().all();
			
	}
	
	
	
	@Test
	public void getCookiesInfo()
	{
       Response res = given()
		
		             .when()
		                   .get("https://www.google.com");
       
       
       //String cookieValue = res.getCookie("AEC");
       //System.out.println(cookieValue);
       
       Map<String, String> cookiesValue = res.getCookies();
       
      // System.out.println(cookiesValue.keySet());
       
       for ( String key : cookiesValue.keySet()) 
       {
    	   String value = res.getCookie(key);
    	   System.out.println(key+"   "+value);
       }
	
		
		
	}
	
	
}

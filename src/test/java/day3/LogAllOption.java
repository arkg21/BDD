package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LogAllOption 
{

	@Test
	public void getLogAllFeaturesOption()
	{
		
         given()
		
		.when()
		     .get("https://www.google.com")
		  
		
		.then()
		     .log().body()
             .log().cookies()
             .log().headers()
             .log().all();
			
		
	}
}

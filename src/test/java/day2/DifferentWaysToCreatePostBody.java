package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DifferentWaysToCreatePostBody 
{
	
	//Using HashMap Method

	//@Test
	public void createUser()
	{
		HashMap data=new HashMap();
		data.put("name", "Naruto");
		data.put("location", "AnimeVerse");
		data.put("phone", "102567");
		
		String coarseArray []= {"Solid", "AutoCadd"};
		data.put("courses", coarseArray);
		
		given()
		     .contentType("application/json")
		     .body(data)
		     
		.when()
		     .post("http://localhost:3000/studentsDetails")
		     
		.then()
		     .statusCode(201)
		     .body("name", equalTo("Naruto"))
		     .body("location", equalTo("AnimeVerse"))
		     .body("phone", equalTo("102567"))
		     .body("courses[0]", equalTo("Solid"))
	         .header("Content-Type", "application/json; charset=utf-8")
	         .log().all();
	}
	
	
	//Using .org Json library
	
	//@Test
	public void createUserUsingJSONLibrary()
	{
		JSONObject data=new JSONObject();
		
		data.put("name", "Naruto");
		data.put("location", "AnimeVerse");
		data.put("phone", "102567");
		
		String coarseArray []= {"Solid", "AutoCadd"};
		data.put("courses", coarseArray);
		
		given()
		     .contentType("application/json")
		     .body(data.toString())
		     
		.when()
		     .post("http://localhost:3000/studentsDetails")
		     
		.then()
		     .statusCode(201)
		     .body("name", equalTo("Naruto"))
		     .body("location", equalTo("AnimeVerse"))
		     .body("phone", equalTo("102567"))
		     .body("courses[0]", equalTo("Solid"))
	         .header("Content-Type", "application/json; charset=utf-8")
	         .log().all();
	}
	
	
	//Using POJO Class Library
	
	//@Test
	public void createUserUsingPOJO()
	{
	
			POJO_Class data=new POJO_Class();
			
			data.setName("Minato");
			data.setLocation("RainVillage");
			data.setPhone("11111111");
			
			String coarseArray []= {"Solid", "AutoCadd"};
			data.setCourses(coarseArray);
			
			given()
			     .contentType("application/json")
			     .body(data)
			     
			.when()
			     .post("http://localhost:3000/studentsDetails")
			     
			.then()
			     .statusCode(201)
			     .body("name", equalTo("Minato"))
			     .body("location", equalTo("RainVillage"))
			     .body("phone", equalTo("11111111"))
			     .body("courses[0]", equalTo("Solid"))
		         .header("Content-Type", "application/json; charset=utf-8")
		         .log().all();
		}
	
		
		//Using external JSON File
		
		@Test
		public void createUserUsingExternalFile() throws FileNotFoundException
		{
		
			File f=new File(".//body.json");
			FileReader fr=new FileReader(f);
			
			JSONTokener jd=new JSONTokener(fr);
			JSONObject data=new JSONObject(jd);
				
				given()
				     .contentType("application/json")
				     .body(data.toString())
				     
				.when()
				     .post("http://localhost:3000/studentsDetails")
				     
				.then()
				     .statusCode(201)
				     .body("name", equalTo("Minato"))
				     .body("location", equalTo("RainVillage"))
				     .body("phone", equalTo("11111111"))
				     .body("courses[0]", equalTo("Solid"))
			         .header("Content-Type", "application/json; charset=utf-8")
			         .log().all();
			}
		
			@Test
			public void deleteUser()
			{
				when()
				   .delete("http://localhost:3000/studentsDetails/5")
				   
				.then()
				   .statusCode(200)
				   .log().all();
				   
			}
		
		
}

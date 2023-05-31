package com.api.script;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NewAPIScript {

	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub

		/*RestAssured.given().baseUri("https://restful-booker.herokuapp.com").when().
	log().all().get("/booking").then().log().all();*/
			
    /* RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(getfilecontent("C:\\Users\\03564U744\\eclipse-workspace\\Automation_Booking\\src\\test\\resources\\DataFile\\CreateBooking.txt"))
     .header("Content-Type", "application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").when().log()
    		 .all().post("/booking").then().log().all();*/
		
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification httpRequest = RestAssured.given();
		io.restassured.response.Response response = httpRequest.get("/booking/2183");
		// Retrieve the body of the Response
		String body = response.getBody().toString();
		//response = httpRequest.get("/booking/61").body(body1).post("/booking");
		String jsonString = response.asString();
		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		//System.out.println("Response Body is: " + jsonString);
		
	    RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(jsonString)
	     //.header("Content-Type", "application/json")
	    .header("Content-Type", "text/plain").header("Accept","application/json").
	     header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").when().log()
	    		 .all().post("/booking").then().log().all();
	    System.out.println(response.getBody().path("lastname"));
	    Assert.assertEquals(response.getBody().path("lastname"),"Pratyu");		
		
	
    /* RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(getfilecontent("C:\\Users\\03564U744\\eclipse-workspace\\Automation_Booking\\src\\test\\resources\\DataFile\\dataforput.txt"))
     .header("Content-Type", "application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").when().log()
    		 .all().put("/booking/624").then().log().all();*/
     
  /* RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(getfilecontent("C:\\Users\\03564U744\\eclipse-workspace\\Automation_Booking\\src\\test\\resources\\DataFile\\patchdata"))
     .header("Content-Type", "application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").when().log()
    		 .all().patch("/booking/57").then().log().all();*/
     
  /* RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(getfilecontent("C:\\Users\\03564U744\\eclipse-workspace\\Automation_Booking\\src\\test\\resources\\DataFile\\deletedata"))
   .header("Content-Type", "application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").when().log()
  		 .all().delete("/booking/57").then().log().all();*/
   
     
	}
		
	public static String getfilecontent(String filepath) throws FileNotFoundException
	{
		File file = new File(filepath);
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		return sc.next();		
				
	}
	
	}


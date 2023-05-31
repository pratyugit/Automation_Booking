package com.api.script;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Generic {

	public void get(int bookingid)
	{
		RestAssured.given().accept(ContentType.JSON).pathParam("bookingid", bookingid).
		get("https://restful-booker.herokuapp.com/booking/{bookingid}").then().log().all();
	}
	
	public void get(int bookingid)
	{
		RestAssured.given().accept(ContentType.JSON).pathParam("bookingid", bookingid).
		get("https://restful-booker.herokuapp.com/booking/{bookingid}").then().assertThat().sttauscode(200).
		log().all();
	}
	
	public void post() throws FileNotFoundException
	
	{
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(getfilecontent("C:\\Users\\03564U744\\eclipse-workspace\\Automation_Booking\\src\\test\\resources\\DataFile\\CreateBooking.txt"))
	     .header("Content-Type", "application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").when().log()
	    		 .all().post("/booking").then().log().all();
	}
	
	public void put(int bookingid) throws FileNotFoundException
	
	{
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com").body(getfilecontent("C:\\Users\\03564U744\\eclipse-workspace\\Automation_Booking\\src\\test\\resources\\DataFile\\dataforput.txt"))
    .header("Content-Type", "application/json").header("Accept","application/json").header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
    pathParam("bookingid", bookingid). when().log().all().put("/booking/{bookingid}").then().log().all();
	}
	
	public static String getfilecontent(String filepath) throws FileNotFoundException
	{
		File file = new File(filepath);
		Scanner scm = new Scanner(file);
		scm.useDelimiter("\\Z");
		return scm.next();		
				
	}

}

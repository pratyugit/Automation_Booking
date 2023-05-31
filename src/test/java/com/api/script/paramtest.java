package com.api.script;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class paramtest {

	 // TODO Auto-generated method stub

		public static void pathgetparam(int id)
	    {
	        RestAssured.given().accept(ContentType.JSON).pathParam("id", id)
	        .get("https://reqres.in/api/users/{id}").then().log().all();
	    }
		public static void queryparamcell()
	    {
	        RestAssured.given().accept(ContentType.JSON).queryParam("page", 9)
	        .get("https://reqres.in/api/users").then().log().all();
	    }
	    
	    public static void main(String args[])
	    {
	        pathgetparam(2);
	        queryparamcell();
	}
	    
	}



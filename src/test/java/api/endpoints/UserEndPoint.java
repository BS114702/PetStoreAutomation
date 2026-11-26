package api.endpoints;

import org.testng.annotations.Test;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//CRUD methods implimentation
//it means create, retrieve, update and delete operations

public class UserEndPoint {
	
	public static Response creatuser(User payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)//this was mentioned in petstore api thats why we used
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return res;
		
		
	}
	
	public static Response readUser(String userName)
	{
		Response res=given()
				.pathParam("username", userName)
		.when()
			.get(Routes.get_url);
		
		return res;
		
	}
	
	public static Response updateuser(String userName, User payload)
	{
		Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
		.when()
			.put(Routes.update_url);
		
		return res;
	}
	
	public static Response deleteUser(String userName)
	{
		Response res=given()
				.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

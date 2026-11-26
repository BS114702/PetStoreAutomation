package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//CRUD methods implimentation
//it means create, retrieve, update and delete operations

public class UserEndPoint2 {
	
	//method to read properties file to get urls from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//this will load properties file in resources
		//here even properties extension is not needed
		//here "routes" is name of the properties file
		
		return routes;
	}
	
	
	public static Response creatuser(User payload)
	{
		
		String post_url=getURL().getString("post_url");
		
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
		String get_url=getURL().getString("get_url");
		
		Response res=given()
				.pathParam("username", userName)
		.when()
			.get(Routes.get_url);
		
		return res;
		
	}
	
	public static Response updateuser(String userName, User payload)
	{
		
		String update_url=getURL().getString("update_url");
		
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
		String delete_url=getURL().getString("delete_url");
		
		Response res=given()
				.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);
		
		return res;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

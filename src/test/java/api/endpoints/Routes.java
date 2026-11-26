package api.endpoints;
/*
Swagger URL---> https://petstore.swagger.io

create user(post): https://petstore.swagger.io/v2/user
get user(get): https://petstore.swagger.io/v2/user/{username}
update user(put): https://petstore.swagger.io/v2/user/{username}
delete user (delete): https://petstore.swagger.io/v2/user/{username}
	*/

public class Routes {
	
	public static String base_url= "https://petstore.swagger.io/v2";
	
	//made it static so that we can use it in all other classes
	//without creating an object and only using the class name
	
	//public also cuz we can use it in all other classes
	//user word will change when we will test different modules
	
	//USER MODULE
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	//here {username} is path param
	 
	//STORE MODULE
	
	  //here you will create store module urls
	
	
}

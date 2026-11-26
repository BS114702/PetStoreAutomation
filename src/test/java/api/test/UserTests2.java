package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass//this will start before starting all the test methods
	public void setup()
	{
		faker= new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger= LogManager.getLogger(this.getClass());
		//here we initiated logger object
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("************creating user************");
		Response response=UserEndPoint2.creatuser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************user is created************");
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("************reading user info************");
		
		Response response=UserEndPoint2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("************user info displayed************");
	}
	
	@Test(priority=3)
	public void testUpdateByName()
	{
		
		logger.info("************updating user************");
		
		//update data using payload
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response=UserEndPoint2.updateuser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		//response.then().log().body().statusCode(200); this can also b used as assertion
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response responseAfterupdate=UserEndPoint2.readUser(this.userPayload.getUsername());
		responseAfterupdate.then().log().all();
		Assert.assertEquals(responseAfterupdate.statusCode(), 200);
		
		logger.info("************ user is updated************");
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("************deleting user************");
		
		Response response=UserEndPoint2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************user is deleted************");
	} 

}

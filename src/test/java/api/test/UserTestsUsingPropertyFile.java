package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPointsUsingPropertyFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestsUsingPropertyFile extends UserEndPointsUsingPropertyFile {
	
	Faker faker ;
	User userPayload ;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker =new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(6,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		logger.info("<-------Creating user-------->");
		Response response =UserEndPointsUsingPropertyFile.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("<------- user created-------->");
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("<-------Read user-------->");
		Response response =UserEndPointsUsingPropertyFile.ReadUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("<------- user read-------->");
	}
	@Test(priority = 3)
	public void testUpdateUser() {
		//updating datausing payload
		logger.info("<-------updating user-------->");
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		Response response =UserEndPointsUsingPropertyFile.UpdateUser(userPayload, this.userPayload.getUsername());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		//checking data after update
		Response responseAfterUpdate =UserEndPointsUsingPropertyFile.ReadUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("<------- user updated-------->");
	}
	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("<-------Delete user-------->");
		Response response =UserEndPointsUsingPropertyFile.DeleteUser(this.userPayload.getUsername());
	
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("<------- user deleted-------->");
		
		
		
	}
	
	
	

}

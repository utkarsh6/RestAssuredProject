package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker ;
	User userPayload ;
  Logger logger;
	
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
		Response response =UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("<------- user created-------->");
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("<-------Read user-------->");
		Response response =UserEndPoints.ReadUser(this.userPayload.getUsername());
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
		Response response =UserEndPoints.UpdateUser(userPayload, this.userPayload.getUsername());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		//checking data after update
		Response responseAfterUpdate =UserEndPoints.ReadUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("<------- user updated-------->");
	}
	@Test(priority = 4)
	public void testDeleteUser() {
		logger.info("<-------Delete user-------->");
		Response response =UserEndPoints.DeleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("<------- user deleted-------->");
		
		
		
	}
	
	@Test (priority = 5)
	public void testLogin() {
		logger.info("<------Login Test started-------->");
		String username="Utkarsh";
		 userPayload.setPassword(faker.internet().password(6,10));
		Response response= UserEndPoints.LoginUser(username, this.userPayload.getPassword());
		 response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("<------- user logged in-------->");
		
	}
	@Test(priority = 6)
	public void testLogout() {
		logger.info("<------Logout Test Started------>");
//		String  username="Utkarsh";
		Response response= UserEndPoints.LogoutUser();
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("<------Logout Test executed------>");
		
		
	}
	@Test(priority = 7)
	public void testCreateUserLIst() {
		logger.info("<------Create user List started------>");
		User[] userList= new User[2];
		userList[0]= createUser();
		userList[1]=createUser();
		
		Response response=  UserEndPoints.createUserwithList(userList);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("<------- Users created with list-------->");
		
		                          
		
	}

	private User createUser() {
		// TODO Auto-generated method stub
		User user = new User();
        user.setId(faker.idNumber().hashCode());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setPassword(faker.internet().password(6, 10));
        user.setPhone(faker.phoneNumber().cellPhone());
		
		return user;
	}
	
	
	

}

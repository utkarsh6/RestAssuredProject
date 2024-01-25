package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	//passing username from excel and creating using post request 
	Faker faker ;
	User userPayload ;
	
	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String userID,String userName, String fname, String lName,String email,String pwd,String phone) 
	{	
		faker= new Faker();
		userPayload= new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setEmail(email);
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lName);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		Response response =UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 2,dataProvider = "UserNames", dataProviderClass =DataProviders.class )
	public void testDeleteUserByName(String userName) {
		Response response =UserEndPoints.DeleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	

}

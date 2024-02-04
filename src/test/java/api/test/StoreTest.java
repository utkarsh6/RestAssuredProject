
package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTest {
	Faker faker;
	Store storepayload;
	Logger logger;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		storepayload= new Store();
		storepayload.setId(faker.idNumber().hashCode());
		storepayload.setComplete(true);
		storepayload.setPetId(faker.idNumber().hashCode());
		storepayload.setQuantity(faker.number().hashCode());
		storepayload.setShipDate("2024-02-01");
		storepayload.setStatus("placed");
		
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
	public void createstore() {
		Response response= StoreEndPoints.createStoreOrder(storepayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	@Test(priority = 2)
	public void GetstorebyOrderId() {
		Response response= StoreEndPoints.getStoreOrderbyId(this.storepayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);		
	}
	
	@Test (priority = 3)
	public void getOderIdbyInventory() {
		Response response= StoreEndPoints.getStoreOrderbyInventory();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		
	}
	
	@Test (priority = 4)
	public void deleteStorebyOrderId() {
		Response response= StoreEndPoints.DeleteStorePurchase(this.storepayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	

}

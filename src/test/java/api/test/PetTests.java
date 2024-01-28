package api.test;

import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import api.payload.User;
import io.restassured.response.Response;


public class PetTests {
	
	Faker faker;
	Pet payload;
	public Logger logger;
	
	
	@BeforeClass
	
	public void setup() {
		faker= new Faker();
		payload = new Pet();
		
		payload.setId(faker.number().randomNumber());
		payload.setName(faker.name().name());
		payload.setStatus("available");
		
		Pet.Category category= new Pet.Category();
		
		category.setId(faker.number().randomNumber());
		category.setName(faker.name().name());
		payload.setCategory(category);
	
		
		Pet.Tag tag= new Pet.Tag();
		tag.setId(faker.number().randomNumber());
		
		tag.setName(faker.name().name());
		payload.setTags(Collections.singletonList(tag));
		
		logger = LogManager.getLogger(this.getClass());
	}
	  @Test(priority = 1)
	    public void testCreatePet() {
	        logger.info("<-------Creating pet-------->");
	        Response response = PetEndPoints.createPet(payload);
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("<------- Pet created-------->");
	    }
	  
	  @Test (priority=2)
	  public void testReadUser() {
		  logger.info("<-------Reading pet-------->");
	        Response response = PetEndPoints.ReadPet(this.payload.getId());
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(), 200);
	        logger.info("<------- Pet Read-------->");		  
	  }	  
	  @Test(priority = 3)
	  public void testupdateUser() {
		  logger.info("<------ update user started------>");
		  payload.setName(faker.name().name());
		  Response response= PetEndPoints.updatePet(payload);		  
		  response.then().log().all();
		  Assert.assertEquals(response.getStatusCode(), 200);
		  logger.info("<------ update user completed------>");		  
	  }
	  @Test(priority = 4)
	  public void testdeleteUser() {
		  logger.info("<------delete user started------>");
		  Response response= PetEndPoints.deletePet(this.payload.getId());
		  response.then().log().all();
		  Assert.assertEquals(response.getStatusCode(), 200);
		  logger.info("<------delete user completed------>");
	  }
	  
	  @Test(priority = 5)
	  public void testUploadImageForPet() {
	      logger.info("<-------Uploading image for pet-------->");
	      String imageUrl = "D:\\Eclipse\\RestAssuredProject\\Pet.jpg"; 
	      Response response = PetEndPoints.uploadImage(this.payload.getId(), imageUrl);
	      response.then().log().all();
	      Assert.assertEquals(response.getStatusCode(), 200);
	      logger.info("<------- Image uploaded for pet-------->");
	  }
	  

}

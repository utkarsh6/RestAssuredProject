package api.endpoints;

import api.payload.Pet;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response createPet(Pet payload) {
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
		when().post(Routes.Pet_post_url);		
		return response;		
	}
	
	public static Response ReadPet(long petId) {
		
		Response response= given().pathParam("petId", petId).when().get(Routes.Pet_Get_url);
		return response;
	}
	public static Response updatePet(Pet payload) {
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(payload).when().put(Routes.Pet_update_url);
				
				return response;
	}
	
	public static Response deletePet(long petId) {
		Response response=given().pathParam("petId", petId).when().delete(Routes.Pet_delete_url);
		return response;
		
	}
	
	public static Response uploadImage(long petId,String imageUrl) {
		File imageFile = new File(imageUrl);
		//D:\Eclipse\RestAssuredProject\Pet.jpg
		
		Response response= given().when().pathParam("petId", petId).contentType("multipart/form-data")
                .multiPart("file", imageFile).when()
                .post(Routes.Pet_post_photo_url);
		return response;
	}

}

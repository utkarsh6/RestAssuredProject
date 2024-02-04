package api.endpoints;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StoreEndPoints {
	
	public static Response createStoreOrder(Store payload) {
		Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
				when().post(Routes.Store_post_url);
		return response;
	}
	
	public static Response getStoreOrderbyId(Integer OrderId) {
		Response response= given().pathParam("orderId", OrderId).
				when().get(Routes.Store_Get_url);
		return response;		
	}
	public static Response getStoreOrderbyInventory() {
		Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).
				when().get(Routes.Store_Get_Inventories_url);
		return response;		
	}
	public static Response DeleteStorePurchase(Integer OrderId) {
		Response response= given().pathParam("orderId", OrderId).
				when().get(Routes.Store_Get_url);
		return response;	
		
	}
	
	
	

}

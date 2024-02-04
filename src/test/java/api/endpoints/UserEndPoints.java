
package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	public static Response createUser( User payload){
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
		when().post(Routes.post_url);
		return response;
		
	}
	public static Response ReadUser(String userName){
		Response response=given().pathParam("username", userName).
		when().get(Routes.get_url);
		return response;
		
		
	}
	public static Response UpdateUser(User payload,String userName){
		Response response=given().pathParam("username", userName).contentType(ContentType.JSON).
				accept(ContentType.JSON).body(payload).
		when().put(Routes.update_url);
		return response;
		
	}
	public static Response DeleteUser(String userName){
		Response response=given().pathParam("username", userName).
		when().delete(Routes.delete_url);
		return response;
		
	}
	
	public static Response LoginUser(String userName,String password) {
		Response response= given().queryParam("username", userName).queryParam("password", password).contentType(ContentType.JSON).
				accept(ContentType.JSON).when().get(Routes.login_url);
		return response;
	}
	
	public static Response LogoutUser() {
		Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).when().
				get(Routes.logout_url);
		return response;
	}
	
	public static Response createUserwithList(User[] userList) {
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(userList).when()
				.post(Routes.create_user_list);
				return response;
	}
	


}

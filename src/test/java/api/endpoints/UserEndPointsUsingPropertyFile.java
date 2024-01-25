package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPointsUsingPropertyFile {
	public static Properties properties;
	@BeforeClass
	public static void URL() {
		try {  
		properties = new Properties();
           InputStream input = new 
        		   FileInputStream("D:\\Eclipse\\RestAssuredProject\\src\\test\\resources\\routes.properties");
           properties.load(input);
       } catch (IOException e) {
           e.printStackTrace();
       }
       
		
	}
	public static Response createUser( User payload){
		Response response=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
		when().post(properties.getProperty("post_url"));
		return response;
		
	}
	public static Response ReadUser(String userName){
		Response response=given().pathParam("username", userName).
		when().get(properties.getProperty("get_url"));
		return response;
		
	}
	public static Response UpdateUser(User payload,String userName){
		Response response=given().pathParam("username", userName).contentType(ContentType.JSON).
				accept(ContentType.JSON).body(payload).
		when().put(properties.getProperty("update_url"));
		return response;
		
	}
	public static Response DeleteUser(String userName){
		Response response=given().pathParam("username", userName).
		when().delete(properties.getProperty("delete_url"));
		return response;
		
	}


}

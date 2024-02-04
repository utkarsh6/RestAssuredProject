package api.endpoints;

public class Routes {
	//Swagger URI: https://petstore.swagger.io
	//create : https://petstore.swagger.io/v2/user
	//get:https://petstore.swagger.io/v2/user/{username}
	//Put: https://petstore.swagger.io/v2/user/{username}
	//delete: https://petstore.swagger.io/v2/user{username}
	
	public static String base_url= "https://petstore.swagger.io/v2";
	//user Url
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String update_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";
	
	public static String login_url=base_url+"/user/login";
	
	public static String logout_url= base_url+"/user/logout";
	
	public static String create_user_list=base_url+"/user/createWithList";
	
	//pet URL
	
	public static String Pet_post_url=base_url+"/pet";
	public static String Pet_Get_url= base_url+"/pet/{petId}";
	public static String Pet_update_url=base_url+"/pet";
	public static String Pet_delete_url=base_url+"/pet/{petId}";
	public static String Pet_post_photo_url= base_url+"/pet/{petId}/uploadImage";
	
	//store URL
	public static String Store_post_url=base_url+"/store/order";
	
	
	public static String Store_Get_url=base_url+"/store/order/{orderId}";
	public static String Store_Delete_url= base_url+"/store/order/{orderId}";
	public static String Store_Get_Inventories_url= base_url+"/store/inventory";

}

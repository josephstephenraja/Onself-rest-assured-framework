package api.endpoint;

// created to contain URL

public class Routes {
	
	// admin 
	
	public static String base_url ="https://oneself-api-test.optisolbusiness.com/api";
	
	public static String post_admin_login = base_url+"/admin/login";
	public static String get_my_profile = base_url+"/admin/get-my-profile";
	public static String patch_To_update_the_activestatus =base_url+"/admin/update_active_status/customer/{user_id}";
	

}

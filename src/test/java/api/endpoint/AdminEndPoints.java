package api.endpoint;
import static io.restassured.RestAssured.*;







import Excel.ToReadExcel;
import api.utilies.Authorization;

import api.utilies.ToReadJson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// created to perform CRUD operation

public class AdminEndPoints {
	

	public static Response loginAsAdmin() throws Throwable {
		
	Response response = given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("app_language","en").header("app_version","1")
		.body(ToReadJson.readJson())
		.when().post(ToReadExcel.readData(1, 0,"Sheet1"));
	return response;

	} 
	public static Response myProfile() throws Throwable {
		
	Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("app_language","en").header("app_version","1").header("Authorization",Authorization.apikey)
		.when().get(ToReadExcel.readData(1, 1,"Sheet1"));
	return response;

	}
	
	public static Response update_Status(String string) throws Throwable {
		
		Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("user_id", string)
			.header("app_language","en").header("app_version","1").header("Authorization",Authorization.apikey)
			.when().patch(ToReadExcel.readData(1, 4,"Sheet1"));
		 return response;
		
		

	}
	

	
}

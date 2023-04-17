package api.endpoint;
import static io.restassured.RestAssured.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import Excel.ToReadExcel;
import api.utilies.Authorization;

import api.utilies.ToReadJson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
// created to perform CRUD operation

public class AdminEndPoints {

 static String token;

	public static Response loginAsAdmin() throws Throwable {
		
		
	Response response = given().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("app_language","en").header("app_version","1")
		.body(ToReadJson.readJson())
		.when().post(ToReadExcel.readData(1, 0,"Sheet1"));
	return response ;
	
	} 
	public static String toGenerate() throws Throwable {
		 token = given().contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				 .header("app_language","en").header("app_version","1")
				.body(ToReadJson.readJson())
				.when().post(ToReadExcel.readData(1, 0,"Sheet1")).then().extract().response()
				.jsonPath().getString("result.token");
				 System.out.println("-----------Token Value-----------------------");
				 System.out.println("Token: "+token);
				 System.out.println("-------------End---------------------");
				 return token;
		

	}

	
	public static Response myProfile() throws Throwable {
		
	Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("app_language","en").header("app_version","1").header("Authorization",token)
		.when().get(ToReadExcel.readData(1, 1,"Sheet1"));
	return response;

	}
	
	public static Response update_Status(String string) throws Throwable {
		
		Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("user_id", string)
			.header("app_language","en").header("app_version","1").header("Authorization",token)
			.when().patch(ToReadExcel.readData(1,4,"Sheet1"));
		 return response;
		
		

	}
	

	
}

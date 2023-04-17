package api.test;





import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import Excel.ToReadTestData;
import api.endpoint.AdminEndPoints;
import api.utilies.APIValidations;
import api.utilies.Reports;
import api.utilies.ToReadJson;
import io.restassured.response.Response;

public class AdminTest extends APIValidations {
	
	 @BeforeClass
	 public void toGenerateReport() throws Throwable {
	 Reports.Report(); 
	 Reports.ReportCreateTestcase("API RESPONSE");
	 
	  }
	 
	
	
	public void loginAsAdmin() throws Throwable {
	Reports.ReportCreateTestcase("POST");
	
		Response response =AdminEndPoints.loginAsAdmin();
		response.then().log().all();
     	responsecodevalidation(response, 200);
	    responsestatuslinevalidation(response,ToReadTestData.readExcel(1,4,"Sheet1"));
		responsetimevalidation(response);
		responseHeader(response,ToReadTestData.readExcel(1, 0,"Sheet1"),ToReadTestData.readExcel(1, 1,"Sheet1"));
		
	}
	@Test(dependsOnMethods = {"keyGeneration"})


	public  void my_Profile() throws Throwable {
		Reports.ReportCreateTestcase("GET");
		Response response =AdminEndPoints.myProfile();
		response.then().log().all();
        responsestatuslinevalidation(response,ToReadTestData.readExcel(1,3,"Sheet1"));
        responsetimevalidation(response);
        responsecodevalidation(response, 200);
        responseHeader(response,ToReadTestData.readExcel(2, 0,"Sheet1"),ToReadTestData.readExcel(2, 1,"Sheet1"));
    
		

	}

	@Test(dependsOnMethods = {"keyGeneration"})

	public void activeStatus() throws Throwable {
		Reports.ReportCreateTestcase("PATCH");
		Response response =AdminEndPoints.update_Status(ToReadTestData.readExcel(1,2,"Sheet1"));
		response.then().log().all();
		responsecodevalidation(response, 400);
		responsebodyvalidation( response,ToReadJson.containBody());
		responsetimevalidation(response);
		responseHeader(response,ToReadTestData.readExcel(3, 0,"Sheet1"),ToReadTestData.readExcel(3, 1,"Sheet1"));

	

	}
	@Test
public void keyGeneration() throws Throwable {
	Reports.ReportCreateTestcase("token");
	AdminEndPoints.toGenerate();

}
	
	
	 @AfterClass
	 public static void ReportCooldown() {
		 Reports.ReportCooldown();
	  }
	 
	
	
	

}

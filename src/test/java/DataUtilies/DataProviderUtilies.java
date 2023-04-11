package DataUtilies;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import api.utilies.XLutility;

public class DataProviderUtilies {
	  @DataProvider(name = "Sheet1")
	    public static Object[][] getScenarioDetails1(Method method) {
	        Map<String, HashMap<String, String>> data;
	        data = XLutility.readExcelData("Sheet1");
	        
	        return new Object[][] { { data.get(method.getName()) } };
	    }

}

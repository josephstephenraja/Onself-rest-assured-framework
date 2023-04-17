package api.utilies;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ToReadJson {
	
	public static String readJson() throws Throwable {
		byte[] input =Files.readAllBytes(Paths.get("admin.json"));
		String inputJson = new String(input);
		return inputJson;
	}
	
	public static String update() throws Throwable {
		byte[] input =Files.readAllBytes(Paths.get("update.json"));
		String inputJson = new String(input);
		return inputJson;
		

	}
	
	public static String containBody() throws Throwable {
		byte[] input =Files.readAllBytes(Paths.get("Response.json"));
		String inputJson = new String(input);
		return inputJson;

	}
	

}

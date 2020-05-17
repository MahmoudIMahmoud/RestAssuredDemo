package demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonLoad {

	public static void main(String[] args) throws Exception {
		String jsonStr = readFile("./templates/PetSample.json", StandardCharsets.US_ASCII);
		System.out.println(jsonStr);
		JSONObject jsonObj= new JSONObject();
		JSONParser parser = new JSONParser();
		jsonObj=(JSONObject) parser.parse(jsonStr);
		ArrayList<String> jsList = (ArrayList<String>) jsonObj.get("photoUrls");
		for( String i :jsList)
			System.out.println(i);
		jsList.add("https://whateverpet/test/petsample.png");
		System.out.println(jsonObj.get("photoUrls"));

	}

	static String readFile(String path, Charset encoding) 
			throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	static JSONObject loadJsonTemplateFromFile(String path) {
		try {
			String jsonStr = readFile(path, StandardCharsets.US_ASCII);
			JSONParser parser = new JSONParser();
			return	(JSONObject) parser.parse(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

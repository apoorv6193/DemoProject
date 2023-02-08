package utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dataProviders.ConfigFileReader;

public class JsonDataReader {

	/**
	 * Get JSON data from json file
	 * 
	 * 
	 * @return json data
	 * @throws ParseException
	 * @throws IOException
	 */
	public JSONObject getJsonData() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		ConfigFileReader cfr = new ConfigFileReader();
		FileReader reader = new FileReader(cfr.getInputTestDataPath());
		Object obj = jsonParser.parse(reader);
		JSONObject jsonData = (JSONObject) obj;
		return jsonData;
	}

}

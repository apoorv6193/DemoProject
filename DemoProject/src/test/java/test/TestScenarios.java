package test;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.JsonDataReader;

public class TestScenarios {

	JsonDataReader jsonDataReader;

	@BeforeTest
	public void before() {
		jsonDataReader = new JsonDataReader();
	}

	@Test
	public void validateForeignPlayers() throws IOException, ParseException {
		int fp = 0;
		JSONArray playerDetails = (JSONArray) jsonDataReader.getJsonData().get("player");
		for (int i = 0; i < playerDetails.size(); i++) {
			JSONObject player = (JSONObject) playerDetails.get(i);
			if (!player.get("country").equals("India")) {
				fp++;
			}
		}
		System.out.println("Number of foreign players-- " + fp);
	}

	@Test
	public void validateWicketKeepers() {

	}

}

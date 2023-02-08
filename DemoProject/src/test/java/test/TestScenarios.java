package test;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.TestConstants;
import utils.JsonDataReader;

public class TestScenarios {

	JsonDataReader jsonDataReader;

	@BeforeTest
	public void before() {
		jsonDataReader = new JsonDataReader();
	}

	@Test(description = "Test to validate team has only 4 foreign players")
	public void validateForeignPlayers() throws IOException, ParseException {
		int foreignPlayerCount = 0;
		JSONArray playerDetails = (JSONArray) jsonDataReader.getJsonData().get("player");
		for (int i = 0; i < playerDetails.size(); i++) {
			JSONObject player = (JSONObject) playerDetails.get(i);
			if (!player.get(TestConstants.PLAYER_COUNTRY).equals("India")) {
				foreignPlayerCount++;
			}
		}
		Assert.assertEquals(foreignPlayerCount, 4, "Team does not have 4 foreign players");
	}

	@Test(description = "Test to validate team has atleast 1 wicket keeper")
	public void validateWicketKeepers() throws IOException, ParseException {
		int wicketKeeper = 0;
		JSONArray playerDetails = (JSONArray) jsonDataReader.getJsonData().get("player");
		for (int i = 0; i < playerDetails.size(); i++) {
			JSONObject player = (JSONObject) playerDetails.get(i);
			if (player.get(TestConstants.PLAYER_ROLE).equals("Wicket-keeper")) {
				wicketKeeper++;
			}
		}
		if (wicketKeeper >= 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false, "Team does not have any wicket keeper");
		}
	}
}

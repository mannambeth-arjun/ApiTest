package com.arjun.test;

import com.arjun.api.Weather;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherTest extends BaseTest {

    @Test
    public void validateWeatherInfo() {
        Weather weather = new Weather();
        Response response = weather.searchLocation(configs.getProperty("Location"));
        JSONArray json = new JSONArray(response.asString());
        int id = 0;
        boolean flag = false;
        for (int i = 0; i < json.length(); i++) {
            if (json.getJSONObject(i).getString("title").equals(configs.getProperty("Location1"))) {
                id = json.getJSONObject(i).getInt("woeid");
                flag = true;
            }
        }
        Assert.assertTrue(flag, "Search location not found");
        Response location = weather.getLocation(id + "");
        JSONObject result = new JSONObject(location.asString());
        JSONArray consolidated_weather = result.getJSONArray("consolidated_weather");
        flag=false;
        for (int i = 0; i < consolidated_weather.length(); i++) {
            JSONObject obj = consolidated_weather.getJSONObject(i);
            if (obj.getInt("predictability") >= 75) {
                System.out.println("MinTemp :" + obj.get("min_temp"));
                System.out.println("MaxTemp :" + obj.get("max_temp"));
                System.out.println();
                flag=true;
            }
        }
        Assert.assertTrue(flag, "No result found with predictability>=75");
    }

}

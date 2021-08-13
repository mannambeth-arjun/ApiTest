package com.arjun.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Weather implements ApiResources {

    public Response searchLocation(String keyword) {
        Response response = RestAssured.given().log().all()
                .params(Keywords.QUERY, keyword)
                .get(BASE_URL + LOCATION_SEARCH);
        return response;
    }

    public Response getLocation(String locationId) {
        Response response = RestAssured.given().log().all()
                .get(BASE_URL + LOCATION + locationId);
        return response;
    }


}

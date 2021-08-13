package com.arjun.api;

public interface ApiResources {

    String BASE_URL = "https://www.metaweather.com";

    String LOCATION_SEARCH = "/api/location/search/";
    String LOCATION = "/api/location/";

    interface Keywords{
        String QUERY="query";
    }

}

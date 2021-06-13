package com.amit.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {
    public static final String BASE_URL = "https://www.mocky.io/v2/";
    @GET("5d3a99ed2f0000bac16ec13a")
    Call<WeatherList> getWeatherData();
}

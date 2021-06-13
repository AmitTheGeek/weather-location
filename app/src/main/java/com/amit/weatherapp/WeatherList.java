package com.amit.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherList {
    @SerializedName("data")
    private List<WeatherPojo> weatherPojo;

    public List<WeatherPojo> getWeatherPojo() {
        return weatherPojo;
    }

    public void setWeatherPojo(List<WeatherPojo> weatherPojo) {
        this.weatherPojo = weatherPojo;
    }
}

package com.seunome.weatherapp.services;

import com.seunome.weatherapp.models.WeatherResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    String BASE_URL = "https://api.weatherapi.com/v1/";
    String API_KEY = "25d661df788f47309c5212950250611";

    @GET("forecast.json")
    Call<WeatherResponse> getWeather(
            @Query("key") String key,
            @Query("q") String city,
            @Query("days") int days,
            @Query("lang") String language
    );

    class Factory {
        private static WeatherAPI service;

        public static WeatherAPI getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                service = retrofit.create(WeatherAPI.class);
            }
            return service;
        }
    }
}
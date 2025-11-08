package com.seunome.weatherapp.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {

    // Interface para o Forecast
    public interface Forecast {
        String getDate();
        String getWeekday();
        int getMaxTemp();
        int getMinTemp();
        String getDescription();
        String getCondition();
    }

    @SerializedName("results")
    private Results results;

    public Results getResults() {
        return results;
    }

    public static class Results {
        @SerializedName("city")
        private String city;

        @SerializedName("temp")
        private int temperature;

        @SerializedName("description")
        private String description;

        @SerializedName("forecast")
        private List<ForecastItem> forecast;

        public String getCity() { return city; }
        public int getTemperature() { return temperature; }
        public String getDescription() { return description; }
        public List<ForecastItem> getForecast() { return forecast; }
    }

    // Classe concreta para implementar a interface Forecast
    public static class ForecastItem implements Forecast {
        @SerializedName("date")
        private String date;

        @SerializedName("weekday")
        private String weekday;

        @SerializedName("max")
        private int maxTemp;

        @SerializedName("min")
        private int minTemp;

        @SerializedName("description")
        private String description;

        @SerializedName("condition")
        private String condition;

        public String getDate() { return date; }
        public String getWeekday() { return weekday; }
        public int getMaxTemp() { return maxTemp; }
        public int getMinTemp() { return minTemp; }
        public String getDescription() { return description; }
        public String getCondition() { return condition; }
    }
}
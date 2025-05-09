package controller;

import models.Result;
import models.Tile;
import view.commands.WeatherCommands;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WeatherController {
    private Set<String> weathersSet = new HashSet<>(Arrays.asList("sunny", "rain", "snow", "storm"));
    private String currentWeather;
    private String forecastWeather;

    public String handleCommand(WeatherCommands command) {
        switch (command) {
            case SHOW_WEATHER:
                return displayWeather();
            case PREDICT_WEATHER:
                return "Weather forecast for tomorrow: " + getForecast();
            default:
                return "Unknown command.";
        }
    }

    public String applyWeatherEffects() {
        switch (currentWeather) {
            case "sunny":
                return "Sunny weather: No special effects.";
            case "rain":
                irrigation();
                return "Rainy weather: Crops are irrigated, tool consumption is 1.5x.";
            case "storm":
                thunder(null);
                return "Stormy weather: Thunder struck some tiles.";
            case "snow":
                return "Snowy weather: Energy consumption is doubled.";
            default:
                return "Unknown weather type.";
        }
    }


    public boolean updateWeather() {
        if (currentWeather == null) {
            currentWeather = "sunny"; // پیش‌فرض
        }
        Random random = new Random();
        String[] weatherOptions = weathersSet.toArray(new String[0]);
        currentWeather = weatherOptions[random.nextInt(weatherOptions.length)];
        return true;
    }

    public boolean setWeather(String weatherType) {
        if (weatherType == null || !isValidWeatherType(weatherType)) {
            return false;
        }
        currentWeather = weatherType;
        return true;
    }

    public String getForecast() {
        Random random = new Random();
        String[] weatherOptions = weathersSet.toArray(new String[0]);
        forecastWeather = weatherOptions[random.nextInt(weatherOptions.length)];
        return forecastWeather;
    }


    public String displayWeather() {
        return currentWeather != null ? currentWeather : "Weather not set.";
    }


    private boolean isValidWeatherType(String type) {
        return weathersSet.contains(type.toLowerCase());
    }


    public Result thunder(Tile tile) {
        Random random = new Random();
        String tileAffected;

        if (tile == null) {
            tileAffected = "Tile " + (random.nextInt(100) + 1);
        } else {
            tileAffected = tile.toString();
        }

        // اعمال تاثیرات رعد و برق
        return new Result(true,"Thunder struck " + tileAffected + ". Trees may break or crops may be destroyed.");
    }

    public Result irrigation() {
        return new Result(true,"Crops irrigated successfully.");
    }
}
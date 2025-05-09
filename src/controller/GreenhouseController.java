package controller;

import models.Greenhouse;

public class GreenhouseController {
    private final Greenhouse greenhouse;

    public GreenhouseController(Greenhouse greenhouse) {
        this.greenhouse = greenhouse;
    }

    public String buildGreenhouse(int money) {
        return greenhouse.build(money) ? "Greenhouse built successfully." : "Not enough money to build the greenhouse.";
    }

    public String plantCrop(String crop) {
        return greenhouse.plantCrop(crop);
    }

    public String waterCrops(int water, String weather) {
        return greenhouse.waterCrops(water, weather);
    }

    public String harvestCrops() {
        return greenhouse.harvestCrops();
    }

    public String getGreenhouseStatus() {
        return greenhouse.getStatus();
    }
}
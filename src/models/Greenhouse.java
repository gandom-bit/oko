package models;

import java.util.ArrayList;
import java.util.List;

public class Greenhouse implements StaticElement {
    private boolean isBuilt;
    private List<String> crops; // لیست محصولات داخل گلخانه
    private int waterLevel;
    private int capacity; // ظرفیت محصولات داخل گلخانه

    public Greenhouse() {
        this.isBuilt = false;
        this.crops = new ArrayList<>();
        this.waterLevel = 0;
        this.capacity = 20; // ظرفیت پیش‌فرض گلخانه
    }

    public boolean build(int money) {
        if (money >= 10000) { // هزینه ساخت گلخانه
            this.isBuilt = true;
            return true;
        }
        return false;
    }

    public String plantCrop(String crop) {
        if (!isBuilt) {
            return "The greenhouse is not built yet. Build it first.";
        }
        List<String> giantCrops = List.of("Giant Pumpkin", "Giant Melon", "Giant Cauliflower");
        if (giantCrops.contains(crop)) {
            return crop + " cannot be planted in the greenhouse.";
        }
        if (crops.size() >= capacity) {
            return "The greenhouse is full. Harvest some crops before planting.";
        }
        crops.add(crop);
        return crop + " planted in the greenhouse.";
    }

    public String waterCrops(int water, String weather) {
        if (!isBuilt) {
            return "The greenhouse is not built yet. Build it first.";
        }
        if (weather.equalsIgnoreCase("rain")) {
            return "No need to water crops on a rainy day.";
        }
        waterLevel += water;
        return "Crops watered. Current water level: " + waterLevel;
    }

    public String harvestCrops() {
        if (!isBuilt) {
            return "The greenhouse is not built yet. Build it first.";
        }
        if (crops.isEmpty()) {
            return "No crops to harvest.";
        }
        String harvested = String.join(", ", crops);
        crops.clear();
        return "Crops harvested: " + harvested;
    }

    public String getStatus() {
        if (!isBuilt) {
            return "The greenhouse is not built yet.";
        }
        return "Greenhouse built. Current crops: " + crops.size() + "/" + capacity + ". Water level: " + waterLevel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    @Override
    public char symbol() {
        return 'G';
    }

    @Override
    public boolean isPassable() {
        return false;
    }
}
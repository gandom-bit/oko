package models;

import java.util.Map;

public class Recipe {
    private String name;
    private Map<String, Integer> ingredients;
    private int energyCost;
    private String requiredSkillLevel;
    private int sellPrice;
    private String source;
    private String buff;
    private String rewardSource; // منبع پاداش (مانند شخصیت‌ها یا مراحل)
    private int energyBoost;


    public Recipe(String name, Map<String, Integer> ingredients, int energyCost, String requiredSkillLevel, int sellPrice, String source, String buff, String rewardSource) {
        this.name = name;
        this.ingredients = ingredients;
        this.energyCost = energyCost;
        this.requiredSkillLevel = requiredSkillLevel;
        this.sellPrice = sellPrice;
        this.source = source;
        this.buff = buff;
        this.rewardSource = rewardSource;
        this.energyBoost = 0;
    }

    // گترها
    public String getName() {
        return name;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public String getRequiredSkillLevel() {
        return requiredSkillLevel != null ? requiredSkillLevel : "None";
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public String getSource() {
        return source != null ? source : "Unknown";
    }

    public String getBuff() {
        return buff != null ? buff : "None";
    }

    public String getRewardSource() {
        return rewardSource != null ? rewardSource : "None";
    }

    // ستترها (در صورت نیاز)
    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

    public void setRequiredSkillLevel(String requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setBuff(String buff) {
        this.buff = buff;
    }

    public void setRewardSource(String rewardSource) {
        this.rewardSource = rewardSource;
    }

    @Override
    public String toString() {
        return String.format(
                "Recipe: %s\nIngredients: %s\nEnergy Cost: %d\nRequired Skill: %s\nSell Price: %d\nSource: %s\nBuff: %s\nReward Source: %s",
                name, ingredients, energyCost, getRequiredSkillLevel(), sellPrice, getSource(), getBuff(), getRewardSource()
        );
    }

    public int getEnergyBoost() {
        return energyBoost;
    }
}
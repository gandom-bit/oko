
package models;

import java.util.Map;

public class Recipe {
    private String name;
    private Map<String, Integer> ingredients;
    private int energyCost;
    private String requiredSkillLevel;
    private int sellPrice;

    public Recipe(String name, Map<String, Integer> ingredients, int energyCost, String requiredSkillLevel, int sellPrice) {
        this.name = name;
        this.ingredients = ingredients;
        this.energyCost = energyCost;
        this.requiredSkillLevel = requiredSkillLevel;
        this.sellPrice = sellPrice;
    }

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
        return requiredSkillLevel;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
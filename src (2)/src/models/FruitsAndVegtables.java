package models;

public class FruitsAndVegtables extends Item {
    private String source;
    private int[] growthStages;
    private int totalHarvestTime;
    private boolean isOneTime;
    private Integer regrowthTime;
    private boolean isEdible;
    private int baseEnergy;
    private String suitableSeason;
    private boolean canBeGiant;



    public String getSource() {
        return source;
    }

    public void setSuitableSeason(String suitableSeason) {
        this.suitableSeason = suitableSeason;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int[] getGrowthStages() {
        return growthStages;
    }

    public void setGrowthStages(int[] growthStages) {
        this.growthStages = growthStages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public void setTotalHarvestTime(int totalHarvestTime) {
        this.totalHarvestTime = totalHarvestTime;
    }

    public boolean isOneTime() {
        return isOneTime;
    }

    public void setOneTime(boolean oneTime) {
        isOneTime = oneTime;
    }

    public Integer getRegrowthTime() {
        return regrowthTime;
    }

    public void setRegrowthTime(Integer regrowthTime) {
        this.regrowthTime = regrowthTime;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
    }

    public int getBaseEnergy() {
        return baseEnergy;
    }

    public void setBaseEnergy(int baseEnergy) {
        this.baseEnergy = baseEnergy;
    }

    public String getSuitableSeason() {
        return suitableSeason;
    }

    public boolean isCanBeGiant() {
        return canBeGiant;
    }

    public void setCanBeGiant(boolean canBeGiant) {
        this.canBeGiant = canBeGiant;
    }

    private int calculateTotalHarvestTime() {
        return 0;
    }


    @Override
    public void use() {
    }


    public boolean canGrowInSeason(String currentSeason) {
        return false;
    }

    public boolean isReadyToHarvest(int currentGrowthDay) {
        return false;
    }

}



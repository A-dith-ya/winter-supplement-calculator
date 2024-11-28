package com.wintersupplement.model;

public class WinterSupplementOutput {
    private String id;
    private boolean isEligible;
    private float baseAmount;
    private float childrenAmount;
    private float supplementAmount;

    public WinterSupplementOutput(String id, boolean isEligible, float baseAmount, float childrenAmount, float supplementAmount) {
        this.id = id;
        this.isEligible = isEligible;
        this.baseAmount = baseAmount;
        this.childrenAmount = childrenAmount;
        this.supplementAmount = supplementAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getIsEligible() {
        return isEligible;
    }

    public void setIsEligible(boolean eligible) {
        isEligible = eligible;
    }

    public float getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(float baseAmount) {
        this.baseAmount = baseAmount;
    }

    public float getChildrenAmount() {
        return childrenAmount;
    }

    public void setChildrenAmount(float childrenAmount) {
        this.childrenAmount = childrenAmount;
    }

    public float getSupplementAmount() {
        return supplementAmount;
    }

    public void setSupplementAmount(float supplementAmount) {
        this.supplementAmount = supplementAmount;
    }
}

package com.wintersupplement.rules;

import com.wintersupplement.model.WinterSupplementOutput;

public class FamilyWithChildrenRule implements WinterSupplementRule {
    public static final float BASE_AMOUNT = 120;
    public static final float CHILDREN_AMOUNT = 20;

    @Override
    public boolean isEligible(boolean isDecemberPayment, String status, int numberOfChildren) {
        return isDecemberPayment && (status.equals("couple") || status.equals("single")) && numberOfChildren > 0;
    }

    @Override
    public WinterSupplementOutput calculateSupplement(String id, int numberOfChildren) {
        // The number of children is capped at 30
        float childrenAmount = Math.min(numberOfChildren * CHILDREN_AMOUNT, 600);
        float supplementAmount = BASE_AMOUNT + childrenAmount;
        return new WinterSupplementOutput(id, true, BASE_AMOUNT, childrenAmount, supplementAmount);
    }
}

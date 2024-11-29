package com.wintersupplement.rules;

import com.wintersupplement.model.WinterSupplementOutput;

public class CoupleNoChildrenRule implements WinterSupplementRule {
    public static final float BASE_AMOUNT = 120;
    public static final float CHILDREN_AMOUNT = 0;

    @Override
    public boolean isEligible(boolean isDecemberPayment, String status, int numberOfChildren) {
        return isDecemberPayment && status.equals("couple") && numberOfChildren == 0;
    }

    @Override
    public WinterSupplementOutput calculateSupplement(String id, int numberOfChildren) {
        return new WinterSupplementOutput(id, true, BASE_AMOUNT, CHILDREN_AMOUNT, BASE_AMOUNT);
    }
}

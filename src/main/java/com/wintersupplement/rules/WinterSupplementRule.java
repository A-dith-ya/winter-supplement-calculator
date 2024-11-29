package com.wintersupplement.rules;

import com.wintersupplement.model.WinterSupplementOutput;

public interface WinterSupplementRule {
    // Determines if the rule is eligible for the given client input
    public boolean isEligible(boolean isDecemberPayment, String status, int numberOfChildren);
    // Calculates the supplement amount to be paid
    public WinterSupplementOutput calculateSupplement(String id, int numberOfChildren);
}

package com.wintersupplement;

import com.wintersupplement.model.WinterSupplementInput;
import com.wintersupplement.model.WinterSupplementOutput;
import com.wintersupplement.rules.CoupleNoChildrenRule;
import com.wintersupplement.rules.FamilyWithChildrenRule;
import com.wintersupplement.rules.SinglePersonRule;
import com.wintersupplement.rules.WinterSupplementRule;

public class RuleEngine {
    private WinterSupplementInput winterSupplementInput;
    private WinterSupplementRule[] rules = new WinterSupplementRule[] {
        new SinglePersonRule(),
        new CoupleNoChildrenRule(),
        new FamilyWithChildrenRule()
    };

    public RuleEngine(WinterSupplementInput winterSupplementInput) {
        this.winterSupplementInput = winterSupplementInput;
    }

    public WinterSupplementOutput calculateWinterSupplementOutput() {
        // Iterate through all the rules to find the eligible one
        for (WinterSupplementRule rule : rules) {
            if (rule.isEligible(winterSupplementInput.getFamilyUnitInPayForDecember(), winterSupplementInput.getFamilyComposition(), winterSupplementInput.getNumberOfChildren())) {
                return rule.calculateSupplement(winterSupplementInput.getId(), winterSupplementInput.getNumberOfChildren());
            }
        }
        // Return default output when no rule is eligible
        return new WinterSupplementOutput(winterSupplementInput.getId(), false, 0, 0, 0);
    }
    
}

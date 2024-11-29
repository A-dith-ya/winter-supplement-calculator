import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wintersupplement.RuleEngine;
import com.wintersupplement.model.WinterSupplementInput;
import com.wintersupplement.model.WinterSupplementOutput;

/**
 * The following test cases use Decision Table Testing to validate the RuleEngine.
 * 
 * Conditions: familyComposition, numberOfChildren, familyUnitInPayForDecember
 * Actions: isEligible, baseAmount, childrenAmount, supplementAmount
 * 
 * | familyComposition | numberOfChildren | familyUnitInPayForDecember | isEligible | baseAmount | childrenAmount | supplementAmount |
 * | -                 | -                | false                      | false      | 0          | 0              | 0                |
 * | single            | 0                | true                       | true       | 60         | 0              | 60               |
 * | single            | 1                | true                       | true       | 120        | 20             | 140              |
 * | couple            | 0                | true                       | true       | 120        | 0              | 120              |
 * | couple            | 30               | true                       | true       | 120        | 600            | 720              |
 */
public class RuleEngineTest {
    @Test
    public void testInelgible() {
        WinterSupplementInput input = new WinterSupplementInput("1", 0, "single", false);
        RuleEngine ruleEngine = new RuleEngine(input);
        WinterSupplementOutput output = ruleEngine.calculateWinterSupplementOutput();
    
        assertFalse(output.getIsEligible());
        assertEquals(0, output.getBaseAmount(), 0);
        assertEquals(0, output.getChildrenAmount(), 0);
        assertEquals(0, output.getSupplementAmount(), 0);
    }

    @Test
    public void testSinglePerson() {
        WinterSupplementInput input = new WinterSupplementInput("1", 0, "single", true);
        RuleEngine ruleEngine = new RuleEngine(input);
        WinterSupplementOutput output = ruleEngine.calculateWinterSupplementOutput();
    
        assertTrue(output.getIsEligible());
        assertEquals(60, output.getBaseAmount(), 0);
        assertEquals(0, output.getChildrenAmount(), 0);
        assertEquals(60, output.getSupplementAmount(), 0);
    }

    @Test
    public void TestSinglePersonWithChildren() {
        WinterSupplementInput input = new WinterSupplementInput("1", 1, "single", true);
        RuleEngine ruleEngine = new RuleEngine(input);
        WinterSupplementOutput output = ruleEngine.calculateWinterSupplementOutput();
    
        assertTrue(output.getIsEligible());
        assertEquals(120, output.getBaseAmount(), 0);
        assertEquals(20, output.getChildrenAmount(), 0);
        assertEquals(140, output.getSupplementAmount(), 0);
    }

    @Test
    public void testChildlessCouple() {
        WinterSupplementInput input = new WinterSupplementInput("1", 0, "couple", true);
        RuleEngine ruleEngine = new RuleEngine(input);
        WinterSupplementOutput output = ruleEngine.calculateWinterSupplementOutput();
    
        assertTrue(output.getIsEligible());
        assertEquals(120, output.getBaseAmount(), 0);
        assertEquals(0, output.getChildrenAmount(), 0);
        assertEquals(120, output.getSupplementAmount(), 0);
    }

    @Test
    public void testCoupleWithChildren() {
        WinterSupplementInput input = new WinterSupplementInput("1", 30, "couple", true);
        RuleEngine ruleEngine = new RuleEngine(input);
        WinterSupplementOutput output = ruleEngine.calculateWinterSupplementOutput();
    
        assertTrue(output.getIsEligible());
        assertEquals(120, output.getBaseAmount(), 0);
        assertEquals(600, output.getChildrenAmount(), 0);
        assertEquals(720, output.getSupplementAmount(), 0);
    }
}

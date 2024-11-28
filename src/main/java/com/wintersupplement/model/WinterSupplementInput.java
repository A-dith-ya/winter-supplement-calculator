package com.wintersupplement.model;

public class WinterSupplementInput {
    private String id;
    private int numberOfChildren;
    private String familyComposition;
    private boolean familyUnitInPayForDecember;
    
    public WinterSupplementInput() {
    }

    public WinterSupplementInput(String id, int numberOfChildren, String familyComposition, boolean familyUnitInPayForDecember) {
        this.id = id;
        this.numberOfChildren = numberOfChildren;
        this.familyComposition = familyComposition;
        this.familyUnitInPayForDecember = familyUnitInPayForDecember;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getFamilyComposition() {
        return familyComposition;
    }

    public void setFamilyComposition(String familyComposition) {
        this.familyComposition = familyComposition;
    }

    public boolean getFamilyUnitInPayForDecember() {
        return familyUnitInPayForDecember;
    }

    public void setFamilyUnitInPayForDecember(boolean familyUnitInPayForDecember) {
        this.familyUnitInPayForDecember = familyUnitInPayForDecember;
    }
}

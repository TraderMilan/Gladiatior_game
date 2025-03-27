package org.example.ability;

public enum Ability {
    ATTACK("Ability to deal damage. Higher attack means higher damage."),
    DEFENCE("Defence can reduce the chances of opponent dealing damage."),
    DEXTERITY("Dexterity increases your damage and reduces opponent´s damage. "),
    SKILL("Skill increases chance for a critical hit and also highers your minimal damage dealt. "),
    LUCK("Luck is important for higher chance for critical hit."),
    HEALTH("Health defines your health points. ");

    private final String description;
    // private final int level;

    Ability(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


}

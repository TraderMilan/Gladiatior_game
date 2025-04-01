package org.example.ability;

public enum Ability {
    ATTACK("Ability to deal damage. Higher attack means higher damage and increased chance for aggressive attack."),
    DEFENCE("Defence reduces damage and chance for critical hit of your opponent."),
    DEXTERITY("Dexterity increases your damage and reduces opponent´s damage."),
    SKILL("Skill increases chance for a critical hit and also highers your minimal damage dealt. "),
    LUCK("Luck is important for higher chance for critical hit."),
    HEALTH("Health defines your health points.(1 point = 10 healths) ");

    private final String description;

    Ability(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }


}

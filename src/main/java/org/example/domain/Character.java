package org.example.domain;

import org.example.ability.Ability;

import java.util.Map;

public abstract class Character {
    protected String name;
    protected Map<Ability, Integer> abilities;

    public Character(String name, Map<Ability, Integer> abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public Map<Ability, Integer> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<Ability, Integer> abilities) {
        this.abilities = abilities;
    }


    public void upgradeAbility(Ability ability, int value) {
        abilities.put(ability, value);
    }

    public void setHealthAfterDamage(int damage) {
        this.abilities.put(Ability.HEALTH, this.getAbilities().get(Ability.HEALTH) - damage);

    }

}

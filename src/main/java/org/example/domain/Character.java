package org.example.domain;

import org.example.ability.Ability;

import java.util.Map;

public abstract class Character {
    protected String name;
    protected Map<Ability, Integer> abilities;

    public Character(String name, Map<Ability, Integer> abilities){
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public Map<Ability, Integer> getAbilities() {
        return abilities;
    }

    public void setAbility(Ability ability, int value){
        abilities.put(ability, value);
    }

    public void setHealth(int damage){
        this.setAbility(Ability.HEALTH, this.getAbilities().get(Ability.HEALTH) - damage);
    }

}

package org.example.domain;

import org.example.ability.Ability;
import org.example.constant.Constant;

import java.util.HashMap;
import java.util.Map;

public class Hero extends Character {
    private int lvl;
    private int upgradingPoints;

    public Hero(String name) {
        super(name, new HashMap<>());
        this.lvl = 1;
        this.abilities = getInitialAbilities();
        this.upgradingPoints = Constant.UPGRADING_POINTS;
    }
    public Hero(String name, Map<Ability, Integer> abilities){
        super(name, abilities);

    }

    public void setUpgradingPoints(int upgradingPoints) {
        this.upgradingPoints += upgradingPoints;
    }

    public int getUpgradingPoints() {
        return upgradingPoints;
    }

    public Map<Ability, Integer> getInitialAbilities() {
        HashMap<Ability, Integer> abilities = new HashMap<>();
        abilities.put(Ability.ATTACK, 1);
        abilities.put(Ability.DEFENCE, 1);
        abilities.put(Ability.DEXTERITY, 1);
        abilities.put(Ability.SKILL, 1);
        abilities.put(Ability.LUCK, 1);
        abilities.put(Ability.HEALTH, 50);

        return abilities;
    }
    public int getLvl(){
        return lvl;
    }

    public void setLvl(int val){
        this.lvl = val;
    }


    public void setName(String name) {
        this.name = name;
    }



    public void increaseAbilities(Ability ability) {

        if (ability == Ability.HEALTH) {
            abilities.put(ability, abilities.get(ability) + Constant.HEALTH_POINTS);
        } else {
            abilities.put(ability, abilities.get(ability) + Constant.NORMAL_POINT);
        }

    }

    public void setAbilitiesReduce(Ability ability) {

        if (ability == Ability.HEALTH) {

            abilities.put(ability, abilities.get(ability) - Constant.HEALTH_POINTS);
        } else {

            abilities.put(ability, abilities.get(ability) - Constant.NORMAL_POINT);
        }

    }


}

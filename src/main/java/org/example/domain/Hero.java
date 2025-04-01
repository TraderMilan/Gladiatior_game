package org.example.domain;

import org.example.ability.Ability;
import org.example.constant.Constant;
import org.example.shopEntities.tools.Elixir;
import org.example.shopEntities.tools.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero extends Character {
    private int lvl;
    private int upgradingPoints;
    private int golds;
    private Weapon weapon;
    private List<Elixir> elixirs;

    public Hero(String name) {
        super(name, new HashMap<>());
        this.lvl = 1;
        this.abilities = getInitialAbilities();
        this.upgradingPoints = Constant.UPGRADING_POINTS;
        this.golds = 0;
        this.weapon = null;
        this.elixirs = new ArrayList<>();
    }

    public Hero(String name, Map<Ability, Integer> abilities) {
        super(name, abilities);

    }
    public void loadWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        if (getWeapon() != null) {
            for (Map.Entry<Ability, Integer> upgrades : getWeapon().getIncreases().entrySet()) {
                if (upgrades.getKey().equals(Ability.HEALTH)) {
                    upgradeAbility(upgrades.getKey(), getAbilities().get(upgrades.getKey()) - (upgrades.getValue() * Constant.HEALTH_POINTS));
                } else {
                    upgradeAbility(upgrades.getKey(), getAbilities().get(upgrades.getKey()) - upgrades.getValue());
                }
            }
        }

        this.weapon = weapon;

        for (Map.Entry<Ability, Integer> upgrades : weapon.getIncreases().entrySet()) {
            if (upgrades.getKey().equals(Ability.HEALTH)) {
                upgradeAbility(upgrades.getKey(), getAbilities().get(upgrades.getKey()) + (upgrades.getValue() * Constant.HEALTH_POINTS));
            } else {
                upgradeAbility(upgrades.getKey(), getAbilities().get(upgrades.getKey()) + upgrades.getValue());
            }
        }

    }

    public int useElixir(Elixir elixir, int fullHealth) {

        if (getElixirs() != null) {
            if (elixir.getName().equals("Shadowveil Draught")) {
                return 0;
            }


            for (Map.Entry<Ability, Double> upgrades : elixir.getUpgrade().entrySet()) {
                int wentFrom = getAbilities().get(upgrades.getKey());
                int to;
                int plus;

                if (upgrades.getKey().equals(Ability.HEALTH)) {
                    plus = (int) ((upgrades.getValue() - 1) * fullHealth);

                    if (wentFrom + plus >= fullHealth) {
                        upgradeAbility(upgrades.getKey(), fullHealth);
                        to = fullHealth;
                    } else {
                        upgradeAbility(upgrades.getKey(), wentFrom + plus);
                        to = wentFrom + plus;
                    }

                } else {
                    to = (int) (wentFrom * upgrades.getValue());
                    upgradeAbility(upgrades.getKey(), to);

                }


                System.out.println("Your " + upgrades.getKey().name() + " went from " + wentFrom + " -> " + to);
            }

        }
        return 1;
    }

    public void addElixir(Elixir elixir) {
        elixirs.add(elixir);
    }

    public void setElixirs(List<Elixir> elixirs) {
        this.elixirs = elixirs;
    }

    public List<Elixir> getElixirs() {
        return elixirs;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setGolds(int golds) {
        this.golds = golds;
    }

    public int getGolds() {
        return golds;
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

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int val) {
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

    public void reduceAbilities(Ability ability) {

        if (ability == Ability.HEALTH) {

            abilities.put(ability, abilities.get(ability) - Constant.HEALTH_POINTS);
        } else {

            abilities.put(ability, abilities.get(ability) - Constant.NORMAL_POINT);
        }

    }


}

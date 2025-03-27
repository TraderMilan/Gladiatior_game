package org.example.domain;

public class Weapon {
    private final String name;
    private final int damage;
    private final int availableFromLvl;

    public Weapon(int damage, String name, int availableFromLvl) {
        this.damage = damage;
        this.name = name;
        this.availableFromLvl = availableFromLvl;
    }

    public int getAvailableFromLvl() {
        return availableFromLvl;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}

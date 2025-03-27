package org.example.domain;

import java.util.List;

public class Shop {
    private final String name;
    private final List<Weapon> weapons;

    public Shop(String name, List<Weapon> weapons) {
        this.name = name;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }
}

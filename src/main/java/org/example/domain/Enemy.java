package org.example.domain;

import org.example.ability.Ability;

import java.util.Map;

public class Enemy extends Character{

    public Enemy(String name, Map<Ability, Integer> abilities) {
        super(name, abilities);
    }



}

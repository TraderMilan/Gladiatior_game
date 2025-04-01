package org.example.utility;

import org.example.ability.Ability;
import org.example.domain.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyGenerator {
    public static Map<Integer, Enemy> createEnemies(){

        Map<Integer, Enemy> enemies = new HashMap<>();

        enemies.put(
                1, new Enemy("Goblin", new HashMap<>(Map.of(
                        Ability.ATTACK, 3,
                        Ability.DEFENCE, 1,
                        Ability.DEXTERITY, 2,
                        Ability.SKILL, 2,
                        Ability.LUCK, 4,
                        Ability.HEALTH, 30
                )))
        );

        enemies.put(
                2, new Enemy("Orc", new HashMap<>(Map.of(
                        Ability.ATTACK, 3,
                        Ability.DEFENCE, 1,
                        Ability.DEXTERITY, 4,
                        Ability.SKILL, 3,
                        Ability.LUCK, 1,
                        Ability.HEALTH, 35
                )))
        );

        enemies.put(
                3, new Enemy("Golem", new HashMap<>(Map.of(
                        Ability.ATTACK, 3,
                        Ability.DEFENCE, 3,
                        Ability.DEXTERITY, 2,
                        Ability.SKILL, 3,
                        Ability.LUCK, 2,
                        Ability.HEALTH, 70
                )))
        );

        enemies.put(
                4, new Enemy("Troll", new HashMap<>(Map.of(
                        Ability.ATTACK, 5,
                        Ability.DEFENCE, 5,
                        Ability.DEXTERITY, 2,
                        Ability.SKILL, 2,
                        Ability.LUCK, 1,
                        Ability.HEALTH, 60
                )))
        );

        enemies.put(
                5, new Enemy("Dragon", new HashMap<>(Map.of(
                        Ability.ATTACK, 5,
                        Ability.DEFENCE, 3,
                        Ability.DEXTERITY, 5,
                        Ability.SKILL, 3,
                        Ability.LUCK, 4,
                        Ability.HEALTH, 60
                )))
        );

        enemies.put(
                6, new Enemy("Witch", new HashMap<>(Map.of(
                        Ability.ATTACK, 6,
                        Ability.DEFENCE, 7,
                        Ability.DEXTERITY, 4,
                        Ability.SKILL, 7,
                        Ability.LUCK, 5,
                        Ability.HEALTH, 100
                )))
        );

        enemies.put(
                7, new Enemy("Vampire", new HashMap<>(Map.of(
                        Ability.ATTACK, 7,
                        Ability.DEFENCE, 7,
                        Ability.DEXTERITY, 8,
                        Ability.SKILL, 5,
                        Ability.LUCK, 9,
                        Ability.HEALTH, 85
                )))
        );

        enemies.put(
                8, new Enemy("Zombie Knight", new HashMap<>(Map.of(
                        Ability.ATTACK, 8,
                        Ability.DEFENCE, 9,
                        Ability.DEXTERITY, 10,
                        Ability.SKILL, 4,
                        Ability.LUCK, 11,
                        Ability.HEALTH, 115
                )))
        );

        enemies.put(
                9, new Enemy("Necromancer", new HashMap<>(Map.of(
                        Ability.ATTACK, 14,
                        Ability.DEFENCE, 11,
                        Ability.DEXTERITY, 12,
                        Ability.SKILL, 9,
                        Ability.LUCK, 13,
                        Ability.HEALTH, 130
                )))
        );

        enemies.put(
                10, new Enemy("Cyclops", new HashMap<>(Map.of(
                        Ability.ATTACK, 12,
                        Ability.DEFENCE, 14,
                        Ability.DEXTERITY, 16,
                        Ability.SKILL, 6,
                        Ability.LUCK, 7,
                        Ability.HEALTH, 130
                )))
        );

        enemies.put(
                11, new Enemy("Phoenix", new HashMap<>(Map.of(
                        Ability.ATTACK, 15,
                        Ability.DEFENCE, 14,
                        Ability.DEXTERITY, 12,
                        Ability.SKILL, 8,
                        Ability.LUCK, 12,
                        Ability.HEALTH, 135
                )))
        );

        enemies.put(
                12, new Enemy("Werewolf", new HashMap<>(Map.of(
                        Ability.ATTACK, 19,
                        Ability.DEFENCE, 15,
                        Ability.DEXTERITY, 15,
                        Ability.SKILL, 10,
                        Ability.LUCK, 11,
                        Ability.HEALTH, 155
                )))
        );

        enemies.put(
                13, new Enemy("Minotaur", new HashMap<>(Map.of(
                        Ability.ATTACK, 16,
                        Ability.DEFENCE, 14,
                        Ability.DEXTERITY, 20,
                        Ability.SKILL, 8,
                        Ability.LUCK, 12,
                        Ability.HEALTH, 140
                )))
        );

        enemies.put(
                14, new Enemy("Hydra", new HashMap<>(Map.of(
                        Ability.ATTACK, 14,
                        Ability.DEFENCE, 19,
                        Ability.DEXTERITY, 19,
                        Ability.SKILL, 17,
                        Ability.LUCK, 10,
                        Ability.HEALTH, 170
                )))
        );

        enemies.put(
                15, new Enemy("Lich", new HashMap<>(Map.of(
                        Ability.ATTACK, 22,
                        Ability.DEFENCE, 25,
                        Ability.DEXTERITY, 26,
                        Ability.SKILL, 20,
                        Ability.LUCK, 22,
                        Ability.HEALTH, 230
                )))
        );

        enemies.put(
                16, new Enemy("Behemoth", new HashMap<>(Map.of(
                        Ability.ATTACK, 20,
                        Ability.DEFENCE, 26,
                        Ability.DEXTERITY, 22,
                        Ability.SKILL, 18,
                        Ability.LUCK, 25,
                        Ability.HEALTH, 200
                )))
        );

        enemies.put(
                17, new Enemy("Titan", new HashMap<>(Map.of(
                        Ability.ATTACK, 29,
                        Ability.DEFENCE, 26,
                        Ability.DEXTERITY, 31,
                        Ability.SKILL, 34,
                        Ability.LUCK, 17,
                        Ability.HEALTH, 250
                )))
        );

        enemies.put(
                18, new Enemy("Abyssal Wyrm", new HashMap<>(Map.of(
                        Ability.ATTACK, 37,
                        Ability.DEFENCE, 42,
                        Ability.DEXTERITY, 45,
                        Ability.SKILL, 39,
                        Ability.LUCK, 28,
                        Ability.HEALTH, 450
                )))
        );

        enemies.put(
                19, new Enemy("God of War The", new HashMap<>(Map.of(
                        Ability.ATTACK, 47,
                        Ability.DEFENCE, 45,
                        Ability.DEXTERITY, 51,
                        Ability.SKILL, 45,
                        Ability.LUCK, 30,
                        Ability.HEALTH, 800
                )))
        );


        return enemies;

    }
}

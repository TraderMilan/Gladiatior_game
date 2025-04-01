package org.example.utility;

import org.example.ability.Ability;
import org.example.domain.Character;
import org.example.domain.Hero;
import org.example.shopEntities.tools.Elixir;

import java.util.Map;


public class PrintUtils {
    public static void printAbilities(Character character) {
        int i = 1;
        for (Map.Entry<Ability, Integer> entry : character.getAbilities().entrySet()) {
            System.out.println(i + ". " + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }

    public static void printHeroWeapon(Hero hero) {
        if (hero.getWeapon() == null) {
            System.out.print("-- No weapons --");
        } else {
            System.out.print(hero.getWeapon().getName() + " -> Adds ");
            for (Map.Entry<Ability, Integer> entry : hero.getWeapon().getIncreases().entrySet()) {
                System.out.print(entry.getValue() + " points to " + entry.getKey().name() + "| ");
            }
        }


    }

    public static void printHeroElixirs(Hero hero) {
        if (hero.getElixirs().isEmpty()) {
            System.out.println("--- No elixirs ---");
        } else {
            for (Elixir elixir : hero.getElixirs()) {
                System.out.print(elixir.getName() + ": " + elixir.getDescription() + "|\n         ");
            }
        }
        System.out.println();
    }


    public static void printAbilitiesInLine(Character character) {
        for (Map.Entry<Ability, Integer> entry : character.getAbilities().entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
        }
        System.out.println();
    }


    public static void printDivider() {
        System.out.print("-------------------------------------\n");
    }

    public static void printLongDivider() {
        System.out.print("-------------------------------------------------------------------------------------\n");
    }
    public static void printBigDivider() {
        System.out.print("*************************************************************************************\n");
    }

    public static void printChoices(Hero hero) {
        if (hero.getLvl() % 3 == 0) {
            System.out.print("0. Boss fight: ");
        } else if (hero.getLvl() == 19) {
            System.out.print("0. Ultimate Boss fight: ");
        } else {
            System.out.print("0. Fight ");
        }
        System.out.println(EnemyGenerator.createEnemies().get(hero.getLvl()).getName() + " (Level " + hero.getLvl() + ")");
        System.out.println("1. Upgrade abilities (" + hero.getUpgradingPoints() + " points left)");
        System.out.println("2. Shops");
        System.out.println("3. Save game");
        System.out.println("4. Exit game");
    }

}

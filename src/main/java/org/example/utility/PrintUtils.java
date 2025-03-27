package org.example.utility;

import org.example.ability.Ability;
import org.example.constant.Constant;
import org.example.domain.Character;
import org.example.domain.Hero;

import java.util.Map;


public class PrintUtils {
    public static void printAbilities(Character character){
        int i = 1;
        for(Map.Entry<Ability, Integer> entry: character.getAbilities().entrySet()){
            System.out.println(i + ". " + entry.getKey() + ": " + entry.getValue());
            i++;
        }
    }

    public static void printAbilitiesInLine(Character character){
        for(Map.Entry<Ability, Integer> entry: character.getAbilities().entrySet()){
            System.out.print(entry.getKey() + ": " + entry.getValue() + ", ");
        }
        System.out.println();
    }

    public static void printDivider(){
        System.out.print("-------------------------------------\n");
    }

    public static void printChoices(Hero hero){
        System.out.println("0. Fight "
                + EnemyGenerator.createEnemies().get(hero.getLvl()).getName() + "(Level " + hero.getLvl() + ")");
        System.out.println("1. Upgrade abilities (" + hero.getUpgradingPoints() + " points left)");
        System.out.println("2. Save game");
        System.out.println("3. Exit game");
    }

}

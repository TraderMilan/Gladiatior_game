package org.example.service;

import org.example.ability.Ability;
import org.example.constant.Constant;
import org.example.domain.Character;
import org.example.domain.Enemy;
import org.example.domain.Hero;
import org.example.utility.InputUtils;
import org.example.utility.PrintUtils;

public class BattleService {
    // TODO Pridať obchody, zbrane a voľby

    public boolean fight(Hero hero, Enemy enemy) throws InterruptedException {
        int count = 1;
        System.out.println("You start the battle first!");
        while (hero.getAbilities().get(Ability.HEALTH) > 0 && enemy.getAbilities().get(Ability.HEALTH) > 0) {
            System.out.println("Your life: " + hero.getAbilities().get(Ability.HEALTH));
            System.out.println("Enemy´s life: " + enemy.getAbilities().get(Ability.HEALTH));

            if (count % 2 != 0) {
                int hit = damage(hero, enemy);
                System.out.println(hero.getName() + " deals " + hit + " damage to " + enemy.getName());
                enemy.setHealth(hit);
            } else {
                int hitE = damage(enemy, hero);
                System.out.println(enemy.getName() + " deals " + hitE + " damage to " + hero.getName());
                hero.setHealth(hitE);
            }
            count++;
            PrintUtils.printDivider();
            Thread.sleep(Constant.BATTLE_DELAY);
        }

        return hero.getAbilities().get(Ability.HEALTH) > 0;

    }

    public int damage(Character attacker, Character defender) {
        int damage = (attacker.getAbilities().get(Ability.ATTACK) * 2) + attacker.getAbilities().get(Ability.DEXTERITY)
                - defender.getAbilities().get(Ability.DEFENCE) - defender.getAbilities().get(Ability.DEXTERITY);
        int minDamage = attacker.getAbilities().get(Ability.SKILL);

        if (damage <= 0) {
            return 0;
        }

        int dealtDamage = (int) (Math.random() * damage) + minDamage;
        int chanceForCritical = (attacker.getAbilities().get(Ability.LUCK) * 2) + attacker.getAbilities().get(Ability.SKILL);
        int critical = (int) (Math.random() * 50) + 1;
        if (critical <= chanceForCritical) {
            dealtDamage = dealtDamage * 2;
        }


        return dealtDamage;


    }


    public boolean isHeroReadyToBattle(Hero hero, Enemy enemy) {
        System.out.println(hero.getName() + " VS " + enemy.getName());
        System.out.println("View your abilities: ");
        PrintUtils.printAbilitiesInLine(hero);
        System.out.println("View enemy abilities: ");
        PrintUtils.printAbilitiesInLine(enemy);

        System.out.println("Are you ready to fight?");
        System.out.println("0. No\n1. Yes");

        int choice = InputUtils.readInt();
        if (choice == 1) {
            System.out.println("Let´s go!");
            return true;
        } else if (choice == 0) {
            System.out.println("You have escaped from battle");
            return false;
        } else {
            System.out.println("Invalid choice, try again:");
            return false;
        }

    }
}

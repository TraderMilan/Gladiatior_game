package org.example.service;

import org.example.ability.Ability;
import org.example.constant.Constant;
import org.example.domain.Character;
import org.example.domain.Enemy;
import org.example.domain.Hero;
import org.example.shopEntities.tools.Elixir;
import org.example.utility.InputUtils;
import org.example.utility.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class BattleService {

    // Main battle cycle, returns true if hero won
    public boolean fight(Hero hero, Enemy enemy) throws InterruptedException {
        int count = 1;
        int fullHealth = hero.getAbilities().get(Ability.HEALTH);
        int invisible = 0;
        System.out.println("You start the battle first!");
        List<Integer> usedElixirs = new ArrayList<>();
        while (hero.getAbilities().get(Ability.HEALTH) > 0 && enemy.getAbilities().get(Ability.HEALTH) > 0) {


            System.out.println("Your life: " + hero.getAbilities().get(Ability.HEALTH));
            System.out.println("Enemy´s life: " + enemy.getAbilities().get(Ability.HEALTH) + "\n");


            if (count % 2 != 0) {

                // Only if you use elixir for invisibility
                if (invisible > 0 && invisible <= 2) {
                    if (invisible < 2) {
                        count--;
                    }
                    invisible++;
                    PrintUtils.printDivider();
                    System.out.println("Opponent missed");
                    PrintUtils.printDivider();
                }

                int move = battleChoices(hero, enemy);

                switch (move) {
                    case 1 -> { // Normal hit
                        int hit = damage(hero, enemy);
                        System.out.println(hero.getName() + " deals " + hit + " damage to " + enemy.getName());
                        enemy.setHealthAfterDamage(hit);
                    }
                    case 2 -> { // Aggressive attack, chance of hitting based on your attack and opponent´s defence
                        int random = (int) (Math.random() * 100) + 1;
                        if (chanceForCriticalHit(hero, enemy) >= random) {
                            int hit = (int) (damage(hero, enemy) * 1.5);
                            enemy.setHealthAfterDamage(hit);
                            System.out.println(hero.getName() + " deals critical " + hit + " damage to " + enemy.getName());
                        } else {
                            System.out.println("You missed!");
                        }

                    }
                    case 3 -> { // Elixir impl
                        if (hero.getElixirs().isEmpty()) {
                            System.out.println("You have no elixirs to use.");
                            count--;
                            break;
                        }
                        System.out.println("Select elixir you want to use: ");
                        int i = 1;
                        for (Elixir elixir : hero.getElixirs()) {
                            if (usedElixirs.contains(i)) {
                                System.out.println(i + ". " + elixir.getName() + " --- has been used ---");
                            } else {
                                System.out.println(i + ". " + elixir.getName() + ": " + elixir.getDescription());
                            }
                            i++;
                        }
                        System.out.println("0. Go back");

                        int elixirChoice;

                        // Valid elixir choice check
                        while (true) {
                            elixirChoice = InputUtils.readInt();

                            if (elixirChoice >= 0 && elixirChoice <= hero.getElixirs().size() && !(usedElixirs.contains(elixirChoice))) {
                                break;
                            }
                            if (usedElixirs.contains(elixirChoice)) {
                                System.out.println("You already used this elixir.");
                                continue;
                            }
                            System.out.println("Invalid choice, try again: ");

                        }
                        if (elixirChoice == 0) { // If true, you used invisible elixir and opponent will miss next 2 rounds
                            count++;
                            break;
                        }

                        usedElixirs.add(elixirChoice);

                        int result = hero.useElixir(hero.getElixirs().get(elixirChoice - 1), fullHealth);
                        System.out.println("You used " + hero.getElixirs().get(elixirChoice - 1).getName());
                        if (result == 0) {
                            count--;
                            invisible++;
                        }


                    }
                }


            } else { // Opponent´s turn
                int hitE = damage(enemy, hero);
                System.out.println(enemy.getName() + " deals " + hitE + " damage to " + hero.getName());
                hero.setHealthAfterDamage(hitE);
            }
            count++;
            PrintUtils.printLongDivider();
            Thread.sleep(Constant.BATTLE_DELAY);
        }

        return hero.getAbilities().get(Ability.HEALTH) > 0;
    }


    public int battleChoices(Hero hero, Enemy enemy) {
        int chance = chanceForCriticalHit(hero, enemy);

        while (true) {
            System.out.println("-- 1. Attack --       -- 2. Aggressive attack ( " + chance + "% ) --       -- 3. Use elixir --");
            int choice = InputUtils.readInt();

            if (choice > 0 && choice <= 3) {
                return choice;
            }
            System.out.println("Invalid choice, try again:");
        }
    }

    // Aggressive attack % of hitting based on attack and opponent´s defence
    public int chanceForCriticalHit(Hero hero, Enemy enemy) {
        int attack = hero.getAbilities().get(Ability.ATTACK);
        int defence = enemy.getAbilities().get(Ability.DEFENCE);
        double ratio = (double) attack / defence;
        double result;

        if (ratio >= 3) {
            result = 100;
        } else if (ratio <= 1.0 / 3) {
            result = 0;
        } else if (ratio == 1) {
            result = 50;
        } else if (ratio > 1) {
            result = 50 + (50 * (ratio - 1)) / 2;
        } else {
            result = (50 * (ratio - 1.0 / 3)) / (2.0 / 3);
        }

        return (int) Math.round(result);
    }


    //Damage calculator based on you luck, attack and dexterity vs opponent´s defence and dexterity
    public int damage(Character attacker, Character defender) {
        int damage = (int) ((attacker.getAbilities().get(Ability.ATTACK) * 2) + attacker.getAbilities().get(Ability.DEXTERITY)
                - (defender.getAbilities().get(Ability.DEFENCE) * 1.5) - defender.getAbilities().get(Ability.DEXTERITY));
        int minDamage = attacker.getAbilities().get(Ability.SKILL);

        if (damage <= 0) {
            return 1;
        }

        int dealtDamage = (int) (Math.random() * damage) + minDamage;

        //Chance for critical hit
        int critical = (attacker.getAbilities().get(Ability.LUCK) * 2) + attacker.getAbilities().get(Ability.SKILL);
        int chanceForCritical = (int) (Math.random() * 200) + 1;
        if (critical >= chanceForCritical) {
            dealtDamage = (int) (dealtDamage * 1.5);
        }


        return dealtDamage;


    }


    public boolean isHeroReadyToBattle(Hero hero, Enemy enemy) {
        PrintUtils.printDivider();
        System.out.println(hero.getName() + " VS " + enemy.getName());
        PrintUtils.printDivider();
        System.out.println(" --- View your abilities: ");
        PrintUtils.printAbilitiesInLine(hero);
        System.out.print("Weapon: ");
        PrintUtils.printHeroWeapon(hero);
        System.out.print("\nElixirs: ");
        PrintUtils.printHeroElixirs(hero);
        System.out.println(" --- View enemy abilities: ");
        PrintUtils.printAbilitiesInLine(enemy);
        PrintUtils.printDivider();
        System.out.println("Are you ready to fight?");
        System.out.println("0. No\n1. Yes");

        int choice = InputUtils.readInt();
        if (choice == 1) {
            System.out.println("Let´s go!");
            PrintUtils.printLongDivider();
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

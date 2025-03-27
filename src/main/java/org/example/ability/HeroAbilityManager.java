package org.example.ability;

import org.example.constant.Constant;
import org.example.domain.Character;
import org.example.domain.Hero;
import org.example.utility.InputUtils;
import org.example.utility.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.service.GameManager.explainAbilities;


public class HeroAbilityManager {
    private Hero hero;

    public HeroAbilityManager(Hero hero) {
        this.hero = hero;
    }

    public void removePoints(Hero hero){
        int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {}
            case 1 -> reducePoints(hero, 0);
            case 2 -> reducePoints(hero, 1);
            case 3 -> reducePoints(hero, 2);
            case 4 -> reducePoints(hero, 3);
            case 5 -> reducePoints(hero, 4);
            case 6 -> reducePoints(hero, 5);
            default -> System.out.println("Invalid choice try again.");
        }
    }




    public void upgradeHero(Hero hero) {
        while (0 < hero.getUpgradingPoints()) {

            if (hero.getUpgradingPoints() > 0) {
                System.out.println("You have " + hero.getUpgradingPoints() + " points to spend on your abilities, choose them wisely");
            }

            System.out.println("0. Explain abilities");
            PrintUtils.printAbilities(hero);


            int choice = InputUtils.readInt(); //DEXTERITY: HEALTH: ATTACK: LUCK: SKILL: DEFENCE:
            PrintUtils.printDivider();
            switch (choice) {
                case 0 -> {
                    explainAbilities();
                }
                case 1 -> addPoints(hero, 0);
                case 2 -> addPoints(hero, 1);
                case 3 -> addPoints(hero, 2);
                case 4 -> addPoints(hero, 3);
                case 5 -> addPoints(hero, 4);
                case 6 -> addPoints(hero, 5);
                default -> {
                    System.out.println("Invalid choice");
                }
            }
            if (hero.getUpgradingPoints() == 0) {
                System.out.println("You have no more points to spend");
            }


        }
    }

    public static void addPoints(Hero hero, int index) {

        List<Ability> abilityList = new ArrayList<>();
        for (Map.Entry<Ability, Integer> entry : hero.getAbilities().entrySet()) {
            abilityList.add(entry.getKey());
        }
        hero.increaseAbilities(abilityList.get(index));
        hero.setUpgradingPoints(-1);

    }
    public static void reducePoints(Hero hero, int index) {

        List<Ability> abilityList = new ArrayList<>();
        for (Map.Entry<Ability, Integer> entry : hero.getAbilities().entrySet()) {
            abilityList.add(entry.getKey());
        }

        if(hero.getAbilities().get(abilityList.get(index)).equals(1)
                || hero.getAbilities().get(abilityList.get(index)).equals(50)){
            System.out.println("You can´t remove points from this ability, it is already at it´s minimum lvl");
        } else {
            hero.setAbilitiesReduce(abilityList.get(index));
            System.out.println("You have removed "
                    + (abilityList.get(index).equals(Ability.HEALTH) ? (Constant.HEALTH_POINTS + " points"): (Constant.NORMAL_POINT + " point"))
                    + " from " + abilityList.get(index));
            hero.setUpgradingPoints(1);

        }


    }

}

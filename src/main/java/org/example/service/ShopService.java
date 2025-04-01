package org.example.service;

import org.example.domain.Hero;
import org.example.shopEntities.ElixirShop;
import org.example.shopEntities.Shop;
import org.example.shopEntities.WeaponShop;
import org.example.shopEntities.tools.Elixir;
import org.example.shopEntities.tools.Tool;
import org.example.shopEntities.tools.Weapon;
import org.example.utility.InputUtils;
import org.example.utility.PrintUtils;

import java.util.List;

public class ShopService {
    private final WeaponShop weaponShop;
    private final ElixirShop elixirShop;

    public ShopService() {
        this.elixirShop = new ElixirShop("Elixir shop");
        this.weaponShop = new WeaponShop("Weapons shop");
    }

    public void goToShop(Hero hero, Shop shop) {
        System.out.println("-------------------------------Welcome to " + shop.getName() + "!-------------------------------");
        System.out.println("0. Exit " + shop.getName());
        System.out.println("1. See " + (shop instanceof ElixirShop ? "elixirs" : "weapons"));
        int choice = InputUtils.readInt();

        switch (choice) {
            case 0 -> {
                return;
            }
            case 1 -> printTools(shop, hero);
            default -> System.out.println("Invalid input, try again.");
        }


    }

    public ElixirShop getElixirShop() {
        return elixirShop;
    }

    public WeaponShop getWeaponShop() {
        return weaponShop;
    }


    public void printTools(Shop shop, Hero hero) {
        List<Tool> tools = shop.getTools();
        PrintUtils.printLongDivider();
        for (int i = 0; i < tools.size(); i++) {
            if (hero.getLvl() < tools.get(i).getAvailableFromLvl()) {
                System.out.print((i + 1) + ". ");
                System.out.printf("%-22s %s%n", tools.get(i).getName(), "--- unlocked ---");
            } else {
                System.out.print((i + 1) + ". ");
                if (tools.get(i) instanceof Weapon) {
                    ((Weapon) tools.get(i)).printWeapon();
                }
                if (tools.get(i) instanceof Elixir) {
                    ((Elixir) tools.get(i)).printElixir();
                }
            }
        }
        System.out.println("-- 0. Exit");
        System.out.println("-- Golds: " + hero.getGolds());
        System.out.println("Select item you want to buy: ");

        //choice validation
        while (true) {
            int choice = InputUtils.readInt();

            if (choice == 0) {
                return;
            } else if (choice < 0 || choice > tools.size()) {
                System.out.println("Select only existing item.");
            } else if (tools.get(choice - 1).getAvailableFromLvl() > hero.getLvl()) {
                System.out.println("Item unlocks from level " + tools.get(choice - 1).getAvailableFromLvl());
            } else if (tools.get(choice - 1).getPrice() > hero.getGolds()) {
                System.out.println("You don´t have enough golds.");
            } else if (hero.getWeapon() != null && hero.getWeapon().getName().equals(tools.get(choice - 1).getName()) || hero.getElixirs().stream()
                    .map(Tool::getName).toList().contains(tools.get(choice-1).getName())) {
                System.out.println("You already have this item."); //Cannot have duplicates
            }
            else {
                System.out.println("Are you sure you want to buy " + tools.get(choice - 1).getName() + " for " + tools.get(choice - 1).getPrice() + " ?");
                System.out.println("0. Yes\n1. No");
                int finalDecision = InputUtils.readInt();

                if (finalDecision == 0) {
                    if (tools.get(choice - 1) instanceof Weapon) {
                        hero.setWeapon((Weapon) tools.get(choice - 1));
                    }
                    if (tools.get(choice - 1) instanceof Elixir) {
                        hero.addElixir((Elixir) tools.get(choice - 1));
                    }

                    hero.setGolds(hero.getGolds() - tools.get(choice - 1).getPrice());
                    System.out.println("Item is now yours!");
                    PrintUtils.printDivider();
                    return;
                } else {
                    System.out.println("Then don´t waste my time!"); //Angry man when buying nothing
                    PrintUtils.printDivider();
                    break;
                }

            }
        }
    }


}


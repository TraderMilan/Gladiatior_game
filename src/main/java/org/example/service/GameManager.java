package org.example.service;

import org.example.ability.Ability;
import org.example.ability.HeroAbilityManager;
import org.example.constant.Constant;
import org.example.domain.Enemy;
import org.example.domain.Hero;
import org.example.utility.EnemyGenerator;
import org.example.utility.InputUtils;
import org.example.utility.PrintUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.*;

public class GameManager {
    private Hero hero;
    private final HeroAbilityManager manager;
    private final Map<Integer, Enemy> enemiesByLevel;
    private final BattleService battleService;

    public GameManager() {
        this.hero = new Hero("nameless");
        this.manager = new HeroAbilityManager(hero);
        this.enemiesByLevel = EnemyGenerator.createEnemies();
        this.battleService = new BattleService();
    }

    public void startGame() throws InterruptedException {
        welcomePlayer();

        while (hero.getLvl() <= enemiesByLevel.size()) {
            final Enemy enemy = this.enemiesByLevel.get(hero.getLvl());
            PrintUtils.printChoices(this.hero);
            System.out.println("Type your command:");
            int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    if (this.battleService.isHeroReadyToBattle(hero, enemy)){
                        int enemyHealth = enemiesByLevel.get(hero.getLvl()).getAbilities().get(Ability.HEALTH);
                        int heroHealth = hero.getAbilities().get(Ability.HEALTH);
                        if (battleService.fight(hero, enemy)){
                            System.out.println("You have won!");
                            System.out.println("You have gained " + hero.getLvl() + " points to spend on your abilities!");
                            hero.setUpgradingPoints(hero.getLvl());
                            hero.setLvl((hero.getLvl() + 1));
                        }
                        else {
                            System.out.println("You have lost!");
                            enemiesByLevel.get(hero.getLvl()).setAbility(Ability.HEALTH, enemyHealth);
                        }

                        hero.setAbility(Ability.HEALTH, heroHealth);
                        System.out.println("You have full health now.");
                        PrintUtils.printDivider();
                        PrintUtils.printDivider();

                    }

                } // FIGHT
                case 1 -> abilitiesImpl();
                case 2 -> saveImpl();
                case 3 -> {
                    System.out.println("Are you sure?\n0. No\n1. Yes ");
                    int quit = InputUtils.readInt();
                    if (quit == 0) {
                        System.out.println("We are back in the game!");
                        PrintUtils.printDivider();
                    } else {
                        System.out.println("Bye");
                        return;
                    }
                }
                default -> System.out.println("Invalid input, try again.");

            }
        }

        System.out.println("You have the game! CONGRATULATIONS!!!");
    }

    public void saveImpl() {
        while (true) {
            PrintUtils.printDivider();
            System.out.print("How do you want to save your game?\nType name: ");
            String fileName = InputUtils.readString();
            String path = "saved-games/" + fileName + ".txt";
            if (new File(path).exists()) {
                System.out.println("Game with name " + fileName + " already exists");
                continue;
            }
            try {

                Files.writeString(Path.of(path), collectHeroData(hero));

            } catch (IOException e) {
                System.out.println("Error while saving game.");
                continue;
            } catch (InvalidPathException e) {
                System.out.println("Invalid path name.");
                continue;
            }
            PrintUtils.printDivider();
            System.out.println("Game saved!");
            break;
        }

    }

    private String collectHeroData(Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append(hero.getLvl()).append("\n");
        sb.append(hero.getName()).append("\n");
        sb.append(hero.getUpgradingPoints()).append("\n");
        for (Ability ability : Ability.values()) {
            sb.append(ability).append(":").append(hero.getAbilities().get(ability)).append("\n");
        }
        return sb.toString();


    }

    public void abilitiesImpl() {
        while (true) {
            System.out.println("Your abilities:");
            PrintUtils.printAbilitiesInLine(hero);
            System.out.print("0. Go back\n1. Spend points (" + hero.getUpgradingPoints() + " points left)\n2. remove points");
            System.out.println("\nType command:");
            int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (hero.getUpgradingPoints() == 0) {
                        System.out.println("You have no points to spend");
                        PrintUtils.printDivider();
                    } else {
                        manager.upgradeHero(hero);
                    }
                }
                case 2 -> {
                    System.out.println("Choose ability where you want to reduce points:");
                    System.out.println("0. Done");
                    PrintUtils.printAbilities(hero);
                    manager.removePoints(hero);
                }
            }
        }
    }

    public void welcomePlayer() {
        System.out.println("\n--- Welcome to Gladiator game! ---\n");
        System.out.println("0. Start new game");
        System.out.println("1. Load game");
        int choice = InputUtils.readInt();
        switch (choice) {
            case 0 -> {
                System.out.println("Let´s go!"); PrintUtils.printDivider();
            }
            case 1 -> {
                Hero hero = loadImpl();
                if (hero != null) {
                    this.hero = hero;
                    return;
                }
            }
            default -> {
                System.out.println("Invalid input try again");

            }
        }

        System.out.println("Enter you name:");
        String name = InputUtils.readString();
        hero.setName(name);
        System.out.println("Hello " + hero.getName() + "! Let´s start the game.");
        System.out.println("\nYour abilities are: ");
        PrintUtils.printAbilitiesInLine(this.hero);
        PrintUtils.printDivider();
        manager.upgradeHero(this.hero);
    }

    public Hero loadImpl() {
        while (true) {
            final File[] savedFiles = new File("saved-games").listFiles();
            if (savedFiles == null || savedFiles.length == 0) {
                System.out.println("No saved games found");
                return null;
            }


            int choice;
            while (true) {
                System.out.println("Enter name of game you want to load: ");
                for (int i = 0; i < savedFiles.length; i++) {
                    System.out.println((i) + ". " + savedFiles[i].getName().replace(".txt", ""));
                }

                choice = InputUtils.readInt();
                if (choice < 0 || choice >= savedFiles.length) {
                    System.out.println("Invalid choice.");
                } else {
                    break;
                }

            }

            String loadGameFiles = savedFiles[choice].getName();
            String path = "saved-games/" + loadGameFiles;
            try {
                String heroData = Files.readString(Path.of(path));
                System.out.println("Game loaded successfully.");
                PrintUtils.printDivider();
                return this.stringToHero(heroData);

            } catch (IOException e) {
                System.out.println("Error while loading data.");
            } catch (InvalidPathException e) {
                System.out.println("Invalid characters in file name!");
            }

        }
    }

    public Hero stringToHero(String heroData) {
        String[] lines = heroData.split("\n");
        int lvl = (Integer.parseInt(lines[0]));
        String heroName = lines[1];
        int points = (Integer.parseInt(lines[2]));
        Map<Ability, Integer> abilities = new HashMap<>();

        for (int i = 3; i < 3 + Ability.values().length; i++) {
            String[] abilityData = lines[i].split(":");
            Ability ability = Ability.valueOf(abilityData[0]);
            int value = Integer.parseInt(abilityData[1]);
            abilities.put(ability, value);

        }
        Hero newHero = new Hero(heroName, abilities);
        newHero.setUpgradingPoints(points);
        newHero.setLvl(lvl);

        return newHero;

    }


    public static void explainAbilities() {
        Arrays.stream(Ability.values()).forEach(entry -> System.out.println(entry.name() + ": " + entry.getDescription()));
    }

}

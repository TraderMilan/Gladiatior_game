package org.example.utility;

import org.example.ability.Ability;
import org.example.shopEntities.tools.Elixir;
import org.example.shopEntities.tools.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolsGenerator {
    public static List<Weapon> generateWeapons() {
        List<Weapon> weapons = new ArrayList<>(List.of(
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 1)), "Rusty Blade", "A dull and worn-out sword, barely effective in battle.", 2, 25),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 3)), "Cracked Hatchet", "A small, damaged axe with limited cutting power.", 2, 42),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 4)), "Iron Mace", "A basic blunt weapon, heavy but slow.", 2, 55),

                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 5)), "Bronze Spear", "A simple spear with decent reach but weak penetration.", 4, 71),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 8)), "Steel Longsword", " A well-crafted sword with balanced attack power.", 4, 112),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 7, Ability.DEXTERITY, 2)), "Reaper’s Scythe", "A curved blade that delivers swift, deadly slashes.", 4, 137),

                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 10)), "Titan’s Wrath", "A sword that killed 100 titans", 6, 177),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 9, Ability.DEXTERITY, 4)), "Shadowfang", "A cursed blade that thrives in darkness, striking unseen.", 6, 189),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 10, Ability.DEXTERITY, 3, Ability.SKILL, 2)), "Stormbreaker", "A mighty warhammer infused with the fury of thunderstorms.", 6, 222),

                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 15)), "Frostfang", "A chilling sword that slows enemies with each hit.", 9, 321),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 12, Ability.DEXTERITY, 6)), "Sword of Death", " A colossal mace wielded only by the strongest warriors.", 9, 382),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 13, Ability.DEXTERITY, 4, Ability.LUCK, 3)), "Nightpiercer", "A legendary spear that glows under the moonlight, piercing through armor.", 9, 451),

                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 15, Ability.DEXTERITY, 8, Ability.LUCK, 7)), "Dragonfang", "A sword forged from the tooth of an ancient dragon.", 12, 611),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 20, Ability.DEXTERITY, 6, Ability.LUCK, 4, Ability.SKILL, 2)), "Bloodreaper", "A wicked scythe that drains the life force of its victims.", 12, 780),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 17, Ability.DEXTERITY, 10, Ability.SKILL, 6, Ability.HEALTH, 6)), "Doomcleaver", "A massive axe that brings devastation with every swing.", 12, 833),

                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 21, Ability.DEXTERITY, 11, Ability.SKILL, 10, Ability.HEALTH, 12)), "Celestial Edge", "A blade infused with the essence of the stars.", 15, 1111),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 25, Ability.DEXTERITY, 9, Ability.SKILL, 11, Ability.HEALTH, 15, Ability.DEFENCE, 5)), "Weapon of Gods", "A colossal warhammer said to be forged by the gods themselves.", 15, 1352),
                new Weapon(new HashMap<>(Map.of(Ability.ATTACK, 31, Ability.DEXTERITY, 12, Ability.SKILL, 7, Ability.HEALTH, 17, Ability.DEFENCE, 6)), "Oblivion Fang", "A cursed blade that devours the souls of those it slays.", 15, 1571)

        ));

        return weapons;
    }

    public static Weapon getWeapon(String name) {
        List<Weapon> weapons = generateWeapons();
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)) {
                return weapon;
            }
        }
        System.out.println("Weapon does not exists.");
        return null;

    }

    public static List<Elixir> generateElixirs(){
        List<Elixir> elixirs = new ArrayList<>(List.of(
                new Elixir("Berserker’s Brew", "Increases attack by 30%", 5, 98, new HashMap<>(Map.of(Ability.ATTACK, 1.3)) ),
                new Elixir("Lesser Healing potion", "Restores 25% of health", 5, 123, new HashMap<>(Map.of(Ability.HEALTH, 1.25)) ),

                new Elixir("Stoneguard Tonic", "Boosts defense by 40%", 8, 213, new HashMap<>(Map.of(Ability.DEFENCE, 1.4)) ),
                new Elixir("Greater Healing potion", "Restores 50% of health", 8, 414, new HashMap<>(Map.of(Ability.HEALTH, 1.5)) ),
                new Elixir("Shadowveil Draught", "Grants temporary invisibility, making enemies miss for 2 turns", 8, 850, new HashMap<>(Map.of(Ability.DEFENCE, 1.0)) ),

                new Elixir("Phantom Essence", "Increases dexterity by 40% and attack by 40%", 12, 622, new HashMap<>(Map.of(Ability.DEXTERITY, 1.4, Ability.ATTACK, 1.4)) ),
                new Elixir("Elixir of Vitality", "Fully restores your health", 12, 1104, new HashMap<>(Map.of(Ability.HEALTH, 2.0)) ),
                new Elixir("Titan’s Blood", "Boosts all abilities by 30%", 12, 1238, new HashMap<>(Map.of(Ability.DEFENCE, 1.3, Ability.ATTACK, 1.3, Ability.HEALTH, 1.3, Ability.DEXTERITY, 1.3, Ability.LUCK, 1.3, Ability.SKILL, 1.3  )) )
        ));

        return elixirs;



    }

}

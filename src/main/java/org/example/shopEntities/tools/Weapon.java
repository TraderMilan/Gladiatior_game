package org.example.shopEntities.tools;

import org.example.ability.Ability;

import java.util.HashMap;
import java.util.Map;

public class Weapon extends Tool {
    private final HashMap<Ability, Integer> increases;

    public Weapon(HashMap<Ability, Integer> increases, String name, String description, int availableFromLvl, int price) {
        super(name, description, availableFromLvl, price);
        this.increases = increases;
    }

    public void printWeapon(){
        HashMap<Ability, Integer> upgrades = this.getIncreases();

        System.out.print(String.format(
                "%-18s %-55s | price: %-3d golds -> ",
                this.getName() + ":",
                this.getDescription(),
                this.getPrice()
        ));
        for (Map.Entry<Ability, Integer> entry: upgrades.entrySet()){
            System.out.print("Adds " + entry.getValue() + " points to " + entry.getKey().name() + "| ");
        }
        System.out.println();
    }


    public HashMap<Ability, Integer> getIncreases() {
        return increases;
    }



}

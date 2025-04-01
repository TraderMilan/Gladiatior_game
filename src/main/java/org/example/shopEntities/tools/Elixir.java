package org.example.shopEntities.tools;

import org.example.ability.Ability;

import java.util.HashMap;

public class Elixir extends Tool{
    private final HashMap<Ability, Double> upgrade;


    public Elixir(String name, String description, int availableFromLvl, int price, HashMap<Ability, Double> upgrade) {
        super(name, description, availableFromLvl, price);
        this.upgrade = upgrade;
    }

    public HashMap<Ability, Double> getUpgrade() {
        return upgrade;
    }


    public void printElixir(){
        HashMap<Ability, Double> upgrades = this.upgrade;

        System.out.print(String.format(
                "%-25s %-70s | price: %-3d golds\n",
                this.getName() + ":",
                this.getDescription(),
                this.getPrice()
        ));

    }

}

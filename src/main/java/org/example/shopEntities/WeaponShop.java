package org.example.shopEntities;

import org.example.utility.ToolsGenerator;

import java.util.ArrayList;


public class WeaponShop extends Shop {

    public WeaponShop(String name) {
        super(name);
        this.tools = new ArrayList<>(ToolsGenerator.generateWeapons());
    }

}

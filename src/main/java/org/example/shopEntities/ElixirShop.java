package org.example.shopEntities;

import org.example.utility.ToolsGenerator;

import java.util.ArrayList;

public class ElixirShop extends Shop{


    public ElixirShop(String name) {
        super(name);
        this.tools = new ArrayList<>(ToolsGenerator.generateElixirs());
    }


}

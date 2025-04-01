package org.example.shopEntities;

import org.example.shopEntities.tools.Tool;

import java.util.ArrayList;
import java.util.List;

public abstract class Shop {
    protected final String name;
    protected List<Tool> tools;


    protected Shop(String name) {
        this.name = name;
        this.tools = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public List<Tool> getTools() {
        return tools;
    }
}

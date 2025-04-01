package org.example.shopEntities.tools;

public abstract class Tool {
    private final String name;
    private final String description;
    private final int availableFromLvl;
    private final int price;

    protected Tool(String name, String description, int availableFromLvl, int price) {
        this.name = name;
        this.description = description;
        this.availableFromLvl = availableFromLvl;
        this.price = price;
    }

    public int getAvailableFromLvl() {
        return availableFromLvl;
    }

    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}

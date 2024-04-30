package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    // Create the variables, as private.
    private String name;
    private String owner;
    private List<Valuable> assets;

    // Create the constructor.
    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.assets = new ArrayList<>();
    }

    // Create the getters.
    public double getValue() {
        double totalValue = 0;
        for (Valuable asset : assets) {
            totalValue += asset.getValue();
        }
        return totalValue;
    }

    public Valuable getMostValuable() {
        if (assets.isEmpty()) {
            return null;
        }

        Valuable mostValuable = assets.get(0);
        for (Valuable asset : assets) {
            if (asset.getValue() > mostValuable.getValue()) {
                mostValuable = asset;
            }
        }
        return mostValuable;
    }

    public Valuable getLeastValuable() {
        if (assets.isEmpty()) {
            return null;
        }

        Valuable leastValuable = assets.get(0);
        for (Valuable asset : assets) {
            if (asset.getValue() < leastValuable.getValue()) {
                leastValuable = asset;
            }
        }
        return leastValuable;
    }

    // Create add method.
    public void add(Valuable asset) {
        assets.add(asset);
    }
}
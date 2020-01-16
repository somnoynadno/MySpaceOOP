package models;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class ProductionBuilding extends Building {

    private ResourceType type;
    private Integer level;
    private Vector<Resource> upgradePrices;

    private final int minUpgradeCost = 0;
    private final int maxUpgradeCost = 50;

    private final int minUpgradeCostIncrement = 0;
    private final int maxUpgradeCostIncrement = 50;

    public ProductionBuilding(ResourceType resourceType) {
        type = resourceType;
        level = 0;

        upgradePrices = new Vector<>();
        for (ResourceType rt : ResourceType.values()) {
            int amount = ThreadLocalRandom.current().nextInt(minUpgradeCost, maxUpgradeCost + 1);
            upgradePrices.add(new Resource(rt, amount));
        }
    }

    public void upgrade() {
        level++;
        for (Resource r : upgradePrices) {
            int amount = ThreadLocalRandom.current().nextInt(minUpgradeCostIncrement, maxUpgradeCostIncrement + 1);
            r.increase(amount);
        }
    }

    public ResourceType getType() {
        return type;
    }

    public Integer getLevel() {
        return level;
    }

    public Vector<Resource> getUpgradePrices() {
        return upgradePrices;
    }
}

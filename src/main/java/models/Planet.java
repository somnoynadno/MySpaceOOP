package models;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Planet {

    private PlanetName name;
    private boolean colonized;

    private Vector<Resource> captureCost;
    private Vector<Resource> innerResources;
    private Vector<ProductionBuilding> productionBuildings;

    private final int minCaptureCostAmount = 100;
    private final int maxCaptureCostAmount = 700;

    private final int minInnerResourceAmount = 200;
    private final int maxInnerResourceAmount = 2000;

    public Planet(PlanetName planetName) {
        name = planetName;
        colonized = false;

        captureCost = new Vector<>();
        for (ResourceType resType : ResourceType.values()) {
            int amount = ThreadLocalRandom.current().nextInt(minCaptureCostAmount, maxCaptureCostAmount + 1);
            Resource r = new Resource(resType, amount);
            captureCost.add(r);
        }

        innerResources = new Vector<>();
        for (ResourceType resType : ResourceType.values()) {
            int amount = ThreadLocalRandom.current().nextInt(minInnerResourceAmount, maxInnerResourceAmount + 1);
            Resource r = new Resource(resType, amount);
            innerResources.add(r);
        }
    }

    public PlanetName getName() {
        return name;
    }

    public boolean isColonized() {
        return colonized;
    }

    public Vector<Resource> getCaptureCost() {
        return captureCost;
    }

    public void setColonized() {
        colonized = true;
        productionBuildings = new Vector<>();

        for (ResourceType rt : ResourceType.values()) {
            productionBuildings.add(new ProductionBuilding(rt));
        }
    }

    public Vector<ProductionBuilding> getProductionBuildings() {
        return productionBuildings;
    }

    public Vector<Resource> getInnerResources() {
        return innerResources;
    }
}

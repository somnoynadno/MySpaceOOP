package models;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Planet {

    private PlanetName name;
    private boolean colonized;

    private Vector<Resource> captureCost;

    private final int minCaptureCostAmount = 100;
    private final int maxCaptureCostAmount = 700;

    public Planet(PlanetName planetName) {
        name = planetName;
        colonized = false;

        captureCost = new Vector<>();
        for (ResourceType resType : ResourceType.values()) {
            int amount = ThreadLocalRandom.current().nextInt(minCaptureCostAmount, maxCaptureCostAmount + 1);
            Resource r = new Resource(resType, amount);
            captureCost.add(r);
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
    }
}

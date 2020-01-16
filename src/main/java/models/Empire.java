package models;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Empire {

    private Vector<Resource> resources;
    private Vector<Planet> colonizedPlanets;

    private final int minResAmount = 500;
    private final int maxResAmount = 1200;

    public Empire() {
        resources = new Vector<>();
        colonizedPlanets = new Vector<>();
        for (ResourceType resType : ResourceType.values()) {
            int amount = ThreadLocalRandom.current().nextInt(minResAmount, maxResAmount + 1);
            Resource r = new Resource(resType, amount);
            resources.add(r);
        }
    }

    public boolean checkCanColonize(Planet planet) {
        Vector<Resource> captureCost = planet.getCaptureCost();
        for (int i = 0; i < captureCost.size(); i++) {
            if (captureCost.get(i).getAmount() > resources.get(i).getAmount()) {
                return false;
            }
        }
        return true;
    }

    public void colonizePlanet(Planet planet) {
        Vector<Resource> captureCost = planet.getCaptureCost();
        for (int i = 0; i < captureCost.size(); i++) {
            resources.get(i).decrease(captureCost.get(i).getAmount());
        }
        planet.setColonized();
        colonizedPlanets.add(planet);
    }

    public boolean checkCanBuyBuilding(ProductionBuilding building) {
        Vector<Resource> upgradePrices = building.getUpgradePrices();
        for (int i = 0; i < upgradePrices.size(); i++) {
            if (upgradePrices.get(i).getAmount() > resources.get(i).getAmount()) {
                return false;
            }
        }
        return true;
    }

    public Vector<Resource> getResources() {
        return resources;
    }

    public Vector<Planet> getColonizedPlanets() {
        return colonizedPlanets;
    }
}

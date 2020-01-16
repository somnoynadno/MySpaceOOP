import models.*;

import java.util.Vector;

public final class Printer {

    public static void printEmpireInfo(Empire empire) {
        System.out.println("Your empire has:");
        for (Resource res : empire.getResources()) {
            System.out.print(String.format("%s:%d ", res.getType(), res.getAmount()));
        }
        System.out.println();
    }

    public static void printEnumeratedPlanets(Vector<Planet> planets) {
        System.out.println("Choose your planet:");

        int i = 1;
        for (Planet planet : planets) {
            System.out.print(String.format("[%d] %s", i, planet.getName()));
            i += 1;
            if (planet.isColonized()) {
                System.out.print(" (colonized)");
            }
            System.out.println();
        }
        System.out.println("...or type '0' to exit");
    }

    public static void printEnumeratedResourceTypes() {
        int i = 1;
        for (ResourceType rt : ResourceType.values()) {
            System.out.println(String.format("[%d] %s", i, rt));
            i += 1;
        }
    }

    public static void printPlanetCaptureCost(Planet planet) {
        System.out.println("Capture cost:");
        for (Resource res : planet.getCaptureCost()) {
            System.out.print(String.format("%s:%d ", res.getType(), res.getAmount()));
        }
        System.out.println();
    }

    public static void printPlanetResources(Planet planet) {
        System.out.println(String.format("%s has:", planet.getName()));
        for (Resource res : planet.getInnerResources()) {
            System.out.print(String.format("%s:%d ", res.getType(), res.getAmount()));
        }
        System.out.println();
    }

    public static void printWantToColonize() {
        System.out.println("Want to colonize?");
        System.out.println("[1] Yos");
        System.out.println("[0] Nep");
    }

    public static void printCapturedPlanetOptions(Planet planet) {
        System.out.println();
        System.out.print(planet.getName());
        System.out.print(":");
        System.out.println();

        System.out.println("[1] Print planet resources");
        System.out.println("[2] Print production buildings");
        System.out.println("[3] Print upgrade prices");
        System.out.println("[4] Print my resources");
        System.out.println("[5] Upgrade building");
        System.out.println("[0] ...back to planets");
    }

    public static void printPlanetProductionBuildings(Planet planet) {
        System.out.println("Buildings:");
        for (ProductionBuilding building : planet.getProductionBuildings()) {
            System.out.println(String.format("%s building: %d level", building.getType(), building.getLevel()));
        }
    }

    public static void printProductionBuildingsUpgradePrices(Planet planet) {
        System.out.println("Buildings:");
        for (ProductionBuilding building : planet.getProductionBuildings()) {
            System.out.println();
            System.out.print(String.format("%s building upgrade to level %d cost:", building.getType(), building.getLevel() + 1));
            System.out.println();
            for (Resource resource : building.getUpgradePrices()) {
                System.out.print(String.format("%s:%d ", resource.getType(), resource.getAmount()));
            }
            System.out.println();
        }
    }
}

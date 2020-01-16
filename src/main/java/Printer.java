import models.Empire;
import models.Planet;
import models.Resource;

import java.util.Vector;

public final class Printer {

    public static void printEmpireInfo(Empire empire) {
        System.out.println("Your empire has:");
        for (Resource res : empire.getResources()) {
            System.out.print(String.format("%s:%d ", res.getType(), res.getAmount()));
        }
        System.out.println();
        System.out.println();
    }

    public static void printPlanets(Vector<Planet> planets) {
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

    public static void printPlanetCaptureCost(Planet planet) {
        System.out.println("Capture cost:");
        for (Resource res : planet.getCaptureCost()) {
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
        System.out.println(planet.getName());
        System.out.print(":");

        System.out.println("[1] Print resources");
        System.out.println("[2] Print buildings");
        System.out.println("[3] Add building");
        System.out.println("[0] Exit");
    }
}

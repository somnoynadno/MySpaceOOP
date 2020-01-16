import models.Empire;
import models.Planet;
import models.PlanetName;

import java.util.Scanner;
import java.util.Vector;

public class Main {

    private static Scanner scanner;
    private static Empire empire;
    private static Vector<Planet> planets;

    public static void main(String[] args) {

        empire = new Empire();
        planets = new Vector<>();

        for (PlanetName name : PlanetName.values()) {
            Planet planet = new Planet(name);
            planets.add(planet);
        }

        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            Printer.printEmpireInfo(empire);
            Printer.printPlanets(planets);

            int i = scanner.nextInt();

            if (i == 0) {
                exit = true;
                continue;
            }

            if (i <= planets.size()) {
                Planet chosenPlanet = planets.get(i - 1);

                if (chosenPlanet.isColonized()) {
                    // handle colonized planet
                    Printer.printCapturedPlanetOptions(chosenPlanet);
                } else {
                    // handle not colonized planet
                    Printer.printPlanetCaptureCost(chosenPlanet);
                    Printer.printWantToColonize();

                    int j = scanner.nextInt();
                    if (j == 1) { // yes
                        if (empire.checkCanColonize(chosenPlanet)) {
                            empire.colonizePlanet(chosenPlanet);
                            System.out.println("Colonized!");
                        } else {
                            System.out.println("Not enough resources!");
                        }
                    } else if (j == 0) { // no
                        System.out.println("OK");
                    } else {
                        System.out.println("Wrong option");
                    }
                }

            } else {
                System.out.println("Wrong option");
            }
        }

        scanner.close();
        System.out.println("Exiting...");
    }
}
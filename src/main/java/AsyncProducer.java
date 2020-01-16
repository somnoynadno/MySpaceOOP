import models.Empire;
import models.Planet;

import java.util.Vector;

public class AsyncProducer implements Runnable {

    private Vector<Planet> planets;
    private Empire empire;
    private final int sleepTime = 1000;

    public AsyncProducer(Vector<Planet> p, Empire e) {
        planets = p;
        empire = e;
    }

    public void run() {
        while (true) {
            for (Planet planet : planets) {
                if (planet.isColonized()) {
                    for (int i = 0; i < planet.getProductionBuildings().size(); i++) {
                        Integer amount = planet.getProductionBuildings().get(i).getLevel();
                        // check for inner resources
                        if (planet.getInnerResources().get(i).getAmount() > amount){
                            // add only if you have enough
                            planet.getInnerResources().get(i).decrease(amount);
                            empire.getResources().get(i).increase(amount);
                        }
                    }
                }
            }

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

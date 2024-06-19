package game.spawners;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Creature;
import game.actors.HuntsmanSpider;

/**
 * HuntsmanSpiderSpawner is a class that represents a huntsman spider spawner
 *
 * @author noahd
 * @version 1.0
 */
public class HuntsmanSpiderSpawner implements Spawner {
    private static final double spawnRate = 0.05;

    /**
     * Attempts to spawn a HuntsmanSpider based on a specific condition
     * @return A new HuntsmanSpider instance if condition is met, null otherwise
     */
    public Creature spawn() {
        if (Math.random() <= spawnRate) {
            return new HuntsmanSpider();
        }
        return null;
    }
}

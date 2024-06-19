package game.spawners;

import engine.actors.Actor;
import engine.positions.Location;
import game.actors.AlienBug;
import game.actors.Creature;
import game.actors.HuntsmanSpider;

/**
 * AlienBugSpawner is a class that represents an alien bug spawner
 *
 * @author noahd
 * @version 1.0
 */
public class AlienBugSpawner implements Spawner {
    private static final double spawnRate = 0.1;

    /**
     * Attempts to spawn an AliengBug based on a specific condition
     * @return A new AlienBug instance if condition is met, null otherwise
     */
    public Creature spawn() {
        if (Math.random() <= spawnRate) {
            return new AlienBug();
        }
        return null;
    }
}

package game.spawners;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Creature;
import game.actors.HuntsmanSpider;
import game.actors.SuspiciousAstronaut;
import game.spawners.Spawner;

/**
 * SuspiciousAstronautSpawner is a class that represents a suspicious astronaut spawner
 *
 * @author noahd
 * @version 1.0
 */
public class SuspiciousAstronautSpawner implements Spawner {
    private static final double spawnRate = 0.05;

    /**
     * Attempts to spawn a SuspiciousAstronaut based on a specific condition
     * @return A new SuspiciousAstronaut if condition is met, null otherwise
     */
    public Creature spawn() {
        if (Math.random() <= spawnRate) {
            return new SuspiciousAstronaut();
        }
        return null;
    }
}

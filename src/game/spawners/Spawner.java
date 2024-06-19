package game.spawners;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Creature;


/**
 * Spawner interface is a class that classifies objects that are capable of spawning
 *
 * @author noahd
 * @version 1.0
 */
public interface Spawner {
    /**
     * Spawns a creature
     * @return An instance that extends the Creature class
     */
    public Creature spawn();
}

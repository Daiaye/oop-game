package game.grounds;

import engine.actors.Actor;
import engine.positions.Ground;
import engine.positions.Location;
import game.actors.Creature;
import game.spawners.Spawner;
import game.utils.Utility;

/**
 * Crater class is a class that represents a crater
 * It has the ability to spawn creatures
 *
 * @author noahd
 * @version 1.0
 */
public class Crater extends Ground {

    private Spawner spawner;
    /**
     * A constructor for the Crater class
     */
    public Crater(Spawner spawner) {
        super('u');
        this.spawner = spawner;
    }

    /**
     * The Crater can experience the passing of time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        Creature creature = spawner.spawn();
        if (creature != null) {
            Location destination = Utility.chooseRandomDestination(location);
            if (!destination.containsAnActor()) {
                destination.addActor(creature);
            }
        }
    }
}

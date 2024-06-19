package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Teleportable interface is a class that allows the implementing class to teleport an actor to a random location
 *
 * @author noahd
 * @version 1.0
 */
public interface Teleportable {
    /**
     * Method that teleports the player to a random coordinate in the current map
     * @param actor The actor being teleported
     * @param map The map the actor is currently in
     * @param x The x coordinate the actor will be teleported to
     * @param y The y coordinate the actor will be teleported to
     */
    public void teleport(Actor actor, GameMap map, int x, int y);
}

package game.maps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Travelable interface is a class that allows the implementing class to be travelled to by an actor
 *
 * @author noahd
 * @version 1.0
 */
public interface Travelable {
    /**
     * Method that allows the actor to travel
     * @param actor The actor that is travelling
     */
    public void travel(Actor actor);
}

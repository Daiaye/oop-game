package game.maps;

import engine.actors.Actor;
import engine.positions.GameMap;
import engine.positions.GroundFactory;

import java.util.List;

/**
 * FactorySpaceshipParking class is a class that represents the Factory spaceship parking lot game map
 *
 * @author noahd
 * @version 1.0
 */
public class FactorySpaceshipParking extends GameMap implements Travelable {
    private static final int X_ARRIVAL = 3;
    private static final int Y_ARRIVAL = 3;

    /**
     * Constructor for the FactorySpaceshipParking class
     * @param groundFactory Factory to create Ground objects
     * @param lines List of Strings representing rows of the map
     */
    public FactorySpaceshipParking(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    /**
     * Method that allows the player to travel to the Factory spaceship parking lot
     * @param actor The actor that is travelling
     */
    public void travel(Actor actor) {
        this.addActor(actor, this.at(X_ARRIVAL,Y_ARRIVAL));
    }

    /**
     * String method
     * @return String that represents the name of this map
     */
    public String toString() {
        return "Factory's Spaceship Parking Lot";
    }
}

package game.maps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.List;

/**
 * Polymorphia class is a class that represents the Polymorphia game map
 *
 * @author noahd
 * @version 1.0
 */
public class Polymorphia extends GameMap implements Travelable {
    private static final int X_ARRIVAL = 15;
    private static final int Y_ARRIVAL = 6;

    /**
     * Constructor for the Polymorphia class
     * @param groundFactory Factory to create Ground objects
     * @param lines List of Strings representing rows of the map
     */
    public Polymorphia(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    /**
     * Method that allows the player to travel to Polymorphia
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
        return "Polymorphia";
    }
}

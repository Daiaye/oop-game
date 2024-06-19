package game.maps;

import engine.actors.Actor;
import engine.positions.GameMap;
import engine.positions.GroundFactory;

import java.sql.Ref;
import java.util.List;

/**
 * Refactorio class is a class that represents the Refactorio game map
 *
 * @author noahd
 * @version 1.0
 */
public class Refactorio extends GameMap implements Travelable {
    private static final int X_ARRIVAL = 15;
    private static final int Y_ARRIVAL = 6;

    /**
     * Constructor for the Refactorio class
     * @param groundFactory Factory to create Ground objects
     * @param lines List of Strings representing rows of the map
     */
    public Refactorio(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    /**
     * Method that allows an actor to travel to Refactorio
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
        return "Refactorio";
    }
}

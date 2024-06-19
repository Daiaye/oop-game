package game.items;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;

/**
 * Monologuable interface is a class that allows a class to add strings to an ArrayList to be monologued
 *
 * @author JakeK
 * @version 1.0
 */
public interface Monologuable {
    /**
     * Interacts with the class' ArrayList to add monologue strings
     */
    public ArrayList<String> monologue(Actor actor);

}

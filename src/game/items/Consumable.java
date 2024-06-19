package game.items;

import engine.actors.Actor;

/**
 * Consumable interface is a class that classifies an item that can be "consumed"
 *
 * @author richieC, NoahD
 * @version 1.0
 */
public interface Consumable {
    /**
     * Affects the actor consuming the consumable with its effect
     */
    public void consume(Actor actor);
    /**
     * A verb to use when displaying the results of eating the consumable
     *
     * @return String, e.g. "eats", "opens"
     */
    public String verb();
    /**
     * An effect to use when displaying the results of eating the consumable
     *
     * @return String, e.g. "gains 1 max hp", "heals 1 hp"
     */
    public String effect();

}

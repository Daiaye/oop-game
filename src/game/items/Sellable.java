package game.items;

import engine.actions.Action;
import engine.actors.Actor;
import engine.positions.GameMap;

public interface Sellable {
    /**
     * Sells this item and adds the value of credits to the actor that sold it
     */
    public void sell(Actor actor, GameMap map);
    /**
     * @return a String detailing what occurs when the actor sells this item
     */
    public String outcome();
}

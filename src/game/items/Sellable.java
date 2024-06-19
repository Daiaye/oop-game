package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

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

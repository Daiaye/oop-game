package game.actions;

import engine.actions.Action;
import engine.actors.Actor;
import engine.positions.GameMap;
import game.items.Consumable;

/**
 * ConsumeAction is a class that represents consuming a consumable
 *
 * @author richieC, NoahD
 * @version 1.0
 */
public class ConsumeAction extends Action {
    private final Consumable consumable;

    /**
     * Constructor
     * Sets the consumable associated with this consumable action
     *
     * @param consumable the consumable associated with this action
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Executes the effect of consuming the consumable upon the actor and returns a String detailing what happened
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A description of the result of the action performed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor.toString();

        consumable.consume(actor);

        result += " " + consumable.verb() + " the " + consumable + " and " + consumable.effect();

        return result;
    }

    /**
     * A description of what the actor can do to the consumable that is displayed in the menu
     *
     * @param actor The actor performing the action.
     * @return The action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " " + consumable.verb() + " the " + consumable;
    }
}

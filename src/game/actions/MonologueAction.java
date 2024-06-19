package game.actions;

import engine.actions.Action;
import engine.actors.Actor;
import engine.positions.GameMap;
import game.items.Consumable;
import game.items.Monologuable;

/**
 * MonologueAction is a class that represents monologuing (which can be used by the AI device)
 *
 * @author JakeK
 * @version 1.0
 */
public class MonologueAction extends Action {
    private final Monologuable monologuable;

    /**
     * Constructor
     * Sets the monologuable associated with this consumable action
     *
     * @param monologuable the monologuable associated with this action
     */
    public MonologueAction(Monologuable monologuable) {
        this.monologuable = monologuable;
    }

    /**
     * Executes the action of generating the monologue string to be displayed to the actor, returning that String
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A monologue string to be displayed to the user
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        int monSize = monologuable.monologue(actor).size();
        int mon_ind = (int) (Math.random() * monSize);


        String result = monologuable.monologue(actor).get(mon_ind);

        return result;
    }

    /**
     * A description of what the actor can do to the monologuable that is displayed in the menu
     *
     * @param actor The actor performing the action.
     * @return The action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " monologues " + monologuable;
    }
}
